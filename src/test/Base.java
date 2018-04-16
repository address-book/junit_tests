package test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Base {

    protected WebDriver driver;
    private Boolean useSauce = System.getProperty("USE_SAUCE") != null;

    @Rule
    public TestName name = new TestName();

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            if (useSauce) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("sauce:job-result=failed");
            } else {
                System.out.println("Test Failed");
            }
        }

        @Override
        protected void succeeded(Description description) {
            if (useSauce) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("sauce:job-result=passed");
            } else {
                System.out.println("Test Passed");
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
    };

    private static DesiredCapabilities createCapabilities(String value) throws FileNotFoundException {
        FileReader file = new FileReader("src/test/config/platforms.yml");
        Map<String, Object> platforms = (Map<String, Object>) new Yaml().load(file);
        Map<String, Object> platform = (Map<String, Object>) platforms.get(value);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String key : platform.keySet()) {
            capabilities.setCapability(key, platform.get(key));
        }
        return capabilities;
    }

    @Before
    public void setup() throws MalformedURLException, FileNotFoundException {
        if (useSauce) {
            String user = System.getenv("SAUCE_USERNAME");
            String key = System.getenv("SAUCE_ACCESS_KEY");

            String platformProperty = System.getProperty("PLATFORM");
            String platform = (platformProperty != null) ? platformProperty : "chrome_mac";
            DesiredCapabilities caps = createCapabilities(platform);

            String url = "https://"+user+":"+key+"@ondemand.saucelabs.com:443/wd/hub";

            String buildEnv = System.getenv("BUILD_TAG");
            caps.setCapability("name", name.getMethodName());
            if (buildEnv != null) {
                caps.setCapability("build", buildEnv);
            }

            driver = new RemoteWebDriver(new URL(url), caps);
        } else {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
            driver = new ChromeDriver();
        }
    }

}
