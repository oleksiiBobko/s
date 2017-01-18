package x.y.z.springtest;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import x.y.z.MyBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testApplicationContext.xml"})
public class TestCase {
    
    private static final Logger LOG = LogManager.getLogger(TestCase.class);
    
    @Autowired
    private MyBean myBean;
    
    @Test
    public void test() {
        LOG.info("call " + myBean.getMessage());
        assertEquals(myBean.getMessage(), "hello from My Bean");
    }
}
