package test.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseSauce extends Base {

    protected RemoteWebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");

        String url = "https://"+username+":"+accesskey+"@ondemand.saucelabs.com:443/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "55.0");

        driver = new RemoteWebDriver(new URL(url), caps);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
