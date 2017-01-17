package x.y.z;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class DevelopmentRunner extends Suite {
    
    public DevelopmentRunner(Class<?> clazz, RunnerBuilder builder) throws InitializationError {
        super(clazz, builder);
        try {
            filter(new DevelopmentCategoryFilter());
        } catch (NoTestsRemainException e) {
            throw new InitializationError(e);
        }
    }

    private static final Logger LOG = LogManager.getLogger(DevelopmentRunner.class);

    public static class DevelopmentCategoryFilter extends Filter {
        
        Pattern p = Pattern.compile(".*(\\()([a-zA-Z0-9_]*)(\\)).*");
        
        @Override
        public String describe() {
            return toString();
        }

        @Override
        public boolean shouldRun(Description description) {
            if (annotatedAsUnderDevelopment(description)) {
                return true;
            }
            
            for (Description each : description.getChildren()) {
                if (shouldRun(each)) {
                    return true;
                }
            }

            return false;
        }

        private boolean annotatedAsUnderDevelopment(Description description) {
            String method = description.getMethodName();
            if(method == null) {
                return false;
            }
            Class<?> testClass = description.getTestClass();
            Method[] methods = testClass.getDeclaredMethods();
            for (Method m : methods) {
                String methodName = m.getName();
                if (matchMethodName(method, methodName)) {
                    UnderDevelopment annotation = m.getAnnotation(UnderDevelopment.class);
                    if (annotation != null) {
                        LOG.info("method under development: " + m);
                        return true;
                    } else {
                        break;
                    }
                }
            }
            return false;
        }

        private boolean matchMethodName(String method, String fullMethodName) {
            
            //check whether one of arguments null or empty 
            if (method == null || method.isEmpty() || fullMethodName == null || fullMethodName.isEmpty()) {
                return false;
            }
            
            if (method.equals(fullMethodName)) {
                return true;
            }
            
            Matcher m = p.matcher(method);
            try {
                if (m.matches()) {
                    String methodName = m.group(2);
                    if (fullMethodName.equals(methodName)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                LOG.warn("exception during method name extraction", e);
            }
            return false;
        }
        
    }

}
