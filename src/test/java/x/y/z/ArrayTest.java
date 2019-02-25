package x.y.z;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void arrayTest() {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] a1 = a.clone();
        Class<?> clazz = a.getClass();
        System.err.println(clazz.getName());
        
        for(Class<?> i : clazz.getInterfaces()) {
            System.err.println(i.getName());
        }
        
    }

}
