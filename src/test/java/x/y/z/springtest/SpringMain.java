package x.y.z.springtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SpringMain {
    
    private static final Logger LOG = LogManager.getLogger(SpringMain.class);
    
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        Result result = core.run(TestCase.class);
        for(Failure f : result.getFailures()) {
            LOG.error("header:" + f.getTestHeader());
            LOG.error("failure:" + f.getMessage());
            LOG.error("trace:" + f.getTrace());
        }
    }

}
