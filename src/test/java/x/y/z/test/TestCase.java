package x.y.z.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestCase {
    
    private static final Logger LOG = LogManager.getLogger(TestCase.class);
    
    @Test
    public void test() {
        LOG.info("run");
    }
    
}
