package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    protected WebDriver browser;

    @Before
    public void setup() throws MalformedURLException {
        String url = "http://localhost:4444/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        browser = new RemoteWebDriver(new URL(url), caps);
    }

    @After
    public void teardown() {
        browser.quit();
    }

}
