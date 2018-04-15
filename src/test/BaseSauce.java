package test;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseSauce extends Base {

    @Before
    public void setup() throws MalformedURLException {
        String user = System.getenv("SAUCE_USERNAME");
        String key = System.getenv("SAUCE_ACCESS_KEY");

        String url = "https://"+user+":"+key+"@ondemand.saucelabs.com:443/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.12");
        caps.setCapability("version", "63.0");

        driver = new RemoteWebDriver(new URL(url), caps);
    }

}
