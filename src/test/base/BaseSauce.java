package test.base;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class BaseSauce extends Base {

    protected RemoteWebDriver driver;

    private static DesiredCapabilities createCapabilities(String value) throws FileNotFoundException, YamlException {
        YamlReader reader = new YamlReader(new FileReader("src/test/config/data.yml"));
        HashMap map = (HashMap) reader.read();
        HashMap config = (HashMap) map.get(value);

        String browser = (String) config.get("browser");
        String version = (String) config.get("version");
        String platform = (String) config.get("platform");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("version", version);

        return capabilities;
    }

    @Before
    public void setup(Method method) throws MalformedURLException, FileNotFoundException, YamlException {
        String USER = System.getenv("SAUCE_USERNAME");
        String KEY = System.getenv("SAUCE_ACCESS_KEY");
        String URL = "https://" + USER + ":" + KEY + "@ondemand.saucelabs.com/wd/hub";
        String buildEnv = System.getenv("BUILD_TAG");

        String configEnv = System.getenv("PLATFORM_CONFIG");
        String configValue;

        if (configEnv == null) {
            configValue = "chrome_mac";
        } else {
            configValue = configEnv;
        }

        DesiredCapabilities caps = createCapabilities(configValue);

        caps.setCapability("name", method.getName());
        if (buildEnv != null) {
            caps.setCapability("build", buildEnv);
        }

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
