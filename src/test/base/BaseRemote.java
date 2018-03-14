package test.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseRemote extends Base {

    protected RemoteWebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();

        String URL = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
