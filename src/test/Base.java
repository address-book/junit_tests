package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class Base {

    protected WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
