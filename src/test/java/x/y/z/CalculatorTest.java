package x.y.z;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(value = Parameterized.class)
public class CalculatorTest {
    
    private static final Logger LOG =  LogManager.getLogger(CalculatorTest.class);
    
    private double expected;
    private double paramOne;
    private double paramTwo;
    
    public CalculatorTest(double expected, double paramOne, double paramTwo) {
        super();
        this.expected = expected;
        this.paramOne = paramOne;
        this.paramTwo = paramTwo;
        LOG.info("Instantiated: " + this);
    }

    @Parameters
    public static Collection<Integer[]> getTestParameters() {
        LOG.info("call for params");
        return Arrays.asList(new Integer[][] { 
            { 2, 1, 1 },
            { 3, 2, 1 },
            { 4, 3, 1 },
        });
    }
    
    @Test
    public void testApp() {
        LOG.info("case invocing: " + this);
        Calculator cal = new Calculator();
        double res = cal.add(paramOne, paramTwo);
        assertEquals(expected, res, 0);
    }

    @Override
    public String toString() {
        return "CalculatorTest [expected=" + expected + ", paramOne=" + paramOne + ", paramTwo=" + paramTwo + "]";
    }
    
}
