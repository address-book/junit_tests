package test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    protected WebDriver browser;

    @Before
    public void setup() {
        System.setProperty("wdm.targetPath", "lib/drivers/");
        ChromeDriverManager.getInstance().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        browser = new ChromeDriver(chromeOptions);
    }

    @After
    public void teardown() {
        browser.quit();
    }

}
