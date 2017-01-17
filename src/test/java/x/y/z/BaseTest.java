package x.y.z;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class BaseTest {
    
    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    
    @Rule
    public RetryRule retryRule = new RetryRule();
    
    @Rule
    public TestName testName = new TestName();
    
    
    @After
    public void after() {
        LOG.info(testName.getMethodName());
    }
}
