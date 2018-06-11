package test.utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mehmetgerceker on 6/13/16.
 */
public class SauceUtils {

    public static RemoteWebDriver getDriver() throws MalformedURLException, FileNotFoundException {
        DesiredCapabilities caps = createCapabilities();

        URL url = getSauceURL();
        return new RemoteWebDriver(url, caps);
    }

    public static DesiredCapabilities createCapabilities() throws FileNotFoundException {
        String platform = readPropertyOrEnv("PLATFORM");
        if(platform == null) {
            return createCapabilities("win_10_edge");
        } else {
            return createCapabilities(platform);
        }
    }

    public static DesiredCapabilities createCapabilities(String value) throws FileNotFoundException {
        DesiredCapabilities capabilities;

        Map<String, Object> platform = parseYAML("src/test/config/platforms.yml", value);

        String browserName = (String) platform.remove("browserName");
        if(browserName.equals("Firefox")) {
            capabilities = DesiredCapabilities.firefox();
        } else if(browserName.equals("Edge")) {
            capabilities = DesiredCapabilities.edge();
        } else if(browserName.equals("IE")) {
            capabilities = DesiredCapabilities.internetExplorer();
        } else {
            capabilities = DesiredCapabilities.chrome();
        }

        for (String key : platform.keySet()) {
            capabilities.setCapability(key, platform.get(key));
        }
        // capabilities.setCapability("build", "Test");

        return capabilities;
    }

    private static Map<String, Object> parseYAML(String filename, String parameter) throws FileNotFoundException {
        FileReader file = new FileReader(filename);
        Map<String, Object> platforms = (Map<String, Object>) new Yaml().load(file);
        return (Map<String, Object>) platforms.get(parameter);
    }

    /**
     * Populates the <code>updates</code> map with the value of the system property/environment variable
     * with the following name:
     * <ol>
     * <li>SAUCE_BAMBOO_BUILDNUMBER</li>
     * <li>JENKINS_BUILD_NUMBER</li>
     * <li>BUILD_TAG</li>
     * <li>BUILD_NUMBER</li>
     * <li>TRAVIS_BUILD_NUMBER</li>
     * <li>CIRCLE_BUILD_NUM</li>
     * </ol>
     */
    public static String getBuildName() {
        List<String> variables = Arrays.asList("SAUCE_BAMBOO_BUILDNUMBER",
                "JENKINS_BUILD_NUMBER",
                "CIRCLE_BUILD_NUM",
                "BUILD_TAG",
                "BUILD_NUMBER",
                "TRAVIS_BUILD_NUMBER");

        for (String variable : variables) {
            String buildName = readPropertyOrEnv(variable);
            if (buildName != null && !buildName.equals("")) {
                return buildName;
            }
        }
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    }

    public static String readPropertyOrEnv(String key) {
        String v = System.getProperty(key);
        if (v == null) {
            return System.getenv(key);
        } else {
            return v;
        }
    }

    public static URL getSauceURL() throws MalformedURLException {
        String username = readPropertyOrEnv("SAUCE_USERNAME");
        String accessKey = readPropertyOrEnv("SAUCE_ACCESS_KEY");

        String sauceUrl = "https://"+username+":"+accessKey+"@ondemand.saucelabs.com/wd/hub";
        return new URL(sauceUrl);
    }
}
