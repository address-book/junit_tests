package test.examples;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import test.Base;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseRemote extends Base {

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();

        String URL = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

}
