package test.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    protected WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
