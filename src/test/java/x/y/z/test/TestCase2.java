package x.y.z.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestCase2 {
    
    private static final Logger LOG = LogManager.getLogger(TestCase2.class);
    
    @Test
    public void test2() {
        LOG.info("run");
    }
    
}
