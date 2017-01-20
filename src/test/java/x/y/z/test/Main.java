package x.y.z.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Main {
    
    private static final Logger LOG = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new RunListener(){
            
            @Override
            public void testStarted(Description description) throws Exception {
                LOG.info("test started " + Thread.currentThread().getName());
            }
            
            @Override
            public void testRunStarted(Description description) throws Exception {
                LOG.info("test run started " + Thread.currentThread().getName());
            }
            
        });
        Result result = core.run(TestCase.class);
        for(Failure f : result.getFailures()) {
            LOG.error("header:" + f.getTestHeader());
            LOG.error("failure:" + f.getMessage());
            LOG.error("trace:" + f.getTrace());
        }
    }

}
