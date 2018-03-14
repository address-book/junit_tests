package test.base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseAuto extends Base {

    protected RemoteWebDriver driver;

    @Before
    public void webdriverManager() {
        System.setProperty("wdm.targetPath", "lib/drivers/auto/");
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.quit();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
