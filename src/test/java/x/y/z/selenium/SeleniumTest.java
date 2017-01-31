package x.y.z.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import x.y.z.BaseTest;


public abstract class SeleniumTest extends BaseTest {
    
    private static final Logger LOG = LogManager.getLogger(SeleniumTest.class);
    WebDriver driver = null;
    
    @Before
    public void startBrowser() {
        try {
            driver = new RemoteWebDriver(
                    new URL("http://192.168.5.47:4444/wd/hub"),
                    //new URL("http://localhost:4444/wd/hub"), 
                    DesiredCapabilities.firefox());
        } catch (Exception e) {
            LOG.error("error during driver initialization", e);
        }
    }
    
    @After
    public void stopBrowser() {
        if(driver != null) {
            driver.close();
        }
    }
}
