package x.y.z;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@Category(Regression.class)
public class TestClass1 extends BaseTest {
    
    private static final Logger LOG =  LogManager.getLogger(TestClass1.class);
    
    @Test
    @UnderDevelopment
    @Parameters(source = TestParams.class, method = TestParams.PARAMS_METHOD_NAME)
    public void test1(Attributes game, Attributes category) {
        LOG.info("call" + game + " " + category);
        assertTrue(true);
    }
    
    @Test
    @UnderDevelopment
    @Ignore("because i can")
    @Parameters(source = TestParams.class, method = TestParams.PARAMS_METHOD_NAME)
    public void test11(Attributes game, Attributes category) {
        LOG.info("call" + game + " " + category);
        assertTrue(true);
    }
    
}
