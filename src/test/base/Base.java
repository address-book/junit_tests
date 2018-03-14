package test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class Base {

    protected WebDriver driver;

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getMethodName() + ": Failed");
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getMethodName() + ": Succeeded");
        }
    };

    @Before
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
