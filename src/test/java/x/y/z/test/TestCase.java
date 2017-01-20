package x.y.z.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestCase {
    
    private static final Logger LOG = LogManager.getLogger(TestCase.class);
    
    @Rule
    public TestWatcher watcher = new TestWatcher() {
        
        protected void starting(Description description) {
            LOG.info("test started " + Thread.currentThread().getName());
        }
        
    };
    
    @Before
    public void before() {
        LOG.info("test before " + Thread.currentThread().getName());
    }
    
    @Test
    public void test1() {
        LOG.info("call");
    }
    
    @Test
    public void test2() {
        LOG.info("call");
    }
    
    @Test
    public void test3() {
        LOG.info("call");
    }
    
}
