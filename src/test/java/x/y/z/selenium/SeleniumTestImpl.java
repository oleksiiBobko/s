package x.y.z.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTestImpl extends SeleniumTest {

    private static final Logger LOG = LogManager.getLogger(SeleniumTestImpl.class);

    @Ignore("selenium take screenshot example")
    @Test
    public void test() {
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        LOG.info("size" + driver.manage().window().getSize());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        } catch (IOException e) {
            LOG.error("can't get screenshot", e);
        }

    }
    
    @Ignore("click on element example")
    @Test
    public void test1() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement list = driver.findElement(By.className("mylist"));
        new Actions(driver).moveToElement(list).click().perform();
        WebElement element = driver.findElement(By.className("item"));
        new Actions(driver).moveToElement(element).click().perform();
        ((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
        LOG.info("done");
    }

}
