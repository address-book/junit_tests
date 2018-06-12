package test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import test.utils.SauceUtils;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Base {
    protected WebDriver driver;
    private Boolean useSauce = System.getProperty("USE_SAUCE") == null;

    protected void sauceDebugMessage(String msg){
        if (useSauce) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("sauce:context=" + msg);
        }
    }

    @Rule
    public TestName name = new TestName();

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            if (useSauce) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("sauce:job-result=failed");
            } else {
                System.out.println("Test Failed");
            }
        }

        @Override
        protected void succeeded(Description description) {
            if (useSauce) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("sauce:job-result=passed");
            } else {
                System.out.println("Test Passed");
            }
        }

        @Override
        protected void finished(Description description) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("sauce:job-name="+name.getMethodName());
            driver.quit();
        }
    };

    @Before
    public void setup() throws MalformedURLException, FileNotFoundException {
//        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("disable-infobars");
//
//        driver = new ChromeDriver(chromeOptions);
        driver = SauceUtils.getDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        };
}
