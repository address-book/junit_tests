package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    protected WebDriver driver;
    private String useSauce = System.getenv("USE_SAUCE");

    @Before
    public void setup() throws MalformedURLException {
        if (useSauce == null) {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
            driver = new ChromeDriver();
        } else {
            String user = System.getenv("SAUCE_USERNAME");
            String key = System.getenv("SAUCE_ACCESS_KEY");

            String url = "https://"+user+":"+key+"@ondemand.saucelabs.com:443/wd/hub";

            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "macOS 10.12");
            caps.setCapability("version", "63.0");

            driver = new RemoteWebDriver(new URL(url), caps);
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
