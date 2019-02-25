package x.y.z;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.reflect.ReflectionFactory;

public class OverrideSystemOut {

    @Test
    public void testOverrideSystemOut() throws Exception {

        PrintStream p = System.out;

        final MethodInterceptor printlnSameLine = new MethodInterceptor() {
            @Override
            public Object intercept(final Object object, final Method method, final Object[] args,
                    final MethodProxy methodProxy) throws Throwable {
                if ("println".equals(method.getName())) {
                    p.println("something else");
                    return null;
                }
                return methodProxy.invokeSuper(object, args);
            }
        };

        final PrintStream proxy = createProxy(PrintStream.class, printlnSameLine);

        Field field = System.class.getField("out");
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, proxy);

        System.out.println("sdfdfg");

    }

    @SuppressWarnings("unchecked")
    private static <T> T createProxy(final Class<PrintStream> classToMock, final MethodInterceptor interceptor) {
        final Enhancer enhancer = new Enhancer();
        enhancer.setUseCache(false); // important
        enhancer.setSuperclass(classToMock);
        enhancer.setCallbackType(interceptor.getClass());
        final Class<?> proxyClass = enhancer.createClass();
        Enhancer.registerCallbacks(proxyClass, new Callback[] { interceptor });
        return (T) newInstance(proxyClass);
    }

    @SuppressWarnings("restriction")
    private static <T> T newInstance(final Class<T> clazz) {
        try {
            final Constructor<?> constructor = ReflectionFactory.getReflectionFactory()
                    .newConstructorForSerialization(clazz, Object.class.getDeclaredConstructor());
            return clazz.cast(constructor.newInstance());
        } catch (NoSuchMethodException e) {
            throw new UnsupportedOperationException(e);
        } catch (InstantiationException e) {
            throw new UnsupportedOperationException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

}
