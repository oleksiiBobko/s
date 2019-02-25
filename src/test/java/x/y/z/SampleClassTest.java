package x.y.z;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

public class SampleClassTest {
    @Test
    public void testInvocationHandler() throws Exception {
    
        SampleClass sample = new SampleClass();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("before");
                    method.invoke(sample, args);
                    System.out.println("after");
                    return null;
            }
        });

        SampleClass proxy = (SampleClass) enhancer.create();
        proxy.test("some string");

    }
//
//    @Test
//    public void testSystem() throws Exception {
//
//        PrintStream p = System.out;
//
//        Field field = System.class.getField("out");
//        Field modifiersField = Field.class.getDeclaredField("modifiers");
//        modifiersField.setAccessible(true);
//        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(PrintStream.class);
//        enhancer.setCallback(new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    method.invoke(p, new String[] {"!!stub!!"});
//                    return null;
//            }
//        });
//
//        PrintStream proxy = (PrintStream) enhancer.create();
//        field.set(null, proxy);
//
//        System.out.println("sdfsdf");
//
//    }

}
