package test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    protected WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("wdm.targetPath", "lib/drivers/");
        ChromeDriverManager.getInstance().setup();
        browser = new ChromeDriver();
    }

    @After
    public void teardown() {
        browser.quit();
    }

}
