package x.y.z.theory;

import static org.junit.Assume.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;

import static org.junit.Assert.*;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AdditionWithTheoriesTest {
    
    private static final Logger LOG = LogManager.getLogger(AdditionWithTheoriesTest.class);
    
    @DataPoints
    public static int[] integers() {
        return new int[] { 0,1 };
    }
    
    @Theory
    public void test(Integer a, Integer b, Integer c, Integer d, Integer e, Integer f, Integer g, Integer h) {
        LOG.info("" + a + b + c + d + e + f + g + h);
    }
    
    @Theory
    public void aPlusBIsGreaterThanAAndGreaterThanB(Integer a, Integer b) {
        assumeTrue(a > 0 && b > 0);
        assertTrue(a + b > a);
        assertTrue(a + b > b);
    }

    @Ignore
    @Theory
    public void additionIsCommutative(Integer a, Integer b) {
        assertTrue(a + b == b + a);
    }
}