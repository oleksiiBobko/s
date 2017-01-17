package x.y.z;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestClass2 extends BaseTest {
    
    private static final Logger LOG =  LogManager.getLogger(TestClass2.class);
    
    @Test
    public void test2() {
        LOG.info("call");
        assertTrue(true);
    }
    
}
