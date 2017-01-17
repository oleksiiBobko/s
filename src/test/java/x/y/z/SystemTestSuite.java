package x.y.z;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.BaseTypeFilter;
import org.junit.extensions.cpsuite.ClasspathSuite.BeforeSuite;
import org.junit.runner.RunWith;

@RunWith(ClasspathSuite.class)
@BaseTypeFilter({ BaseTest.class })
public class SystemTestSuite {
    
    private static final Logger LOG = LogManager.getLogger(SystemTestSuite.class);
    
    @BeforeClass
    public static void beforeClass() {
        LOG.info("call");
    }
    
    @BeforeSuite
    public static void before() {
        LOG.info("call");
    }
    
    @After
    private void after () {
        LOG.info("call");
    }
    
    @AfterClass
    public static void afterClass () {
        LOG.info("call");
    }
    
}
