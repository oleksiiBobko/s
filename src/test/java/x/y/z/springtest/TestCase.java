package x.y.z.springtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import x.y.z.MyBean;
import x.y.z.ProtoBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class TestCase {
    
    private static final Logger LOG = LogManager.getLogger(TestCase.class);

    private static String sample = "sample";

    @Autowired
    private MyBean myBean;
    
    @Autowired
    private ProtoBean proto;
    
    @Test
    public void test() {
        Thread.currentThread().getThreadGroup().getParent().list();
        myBean.getProto();
        String s = new String("sample".getBytes());
        String s1 = s.intern();
        LOG.info("call " + myBean.getProto().getBean());
    }
}
