package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public class Base {

    protected WebDriver driver;

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
