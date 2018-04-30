package test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseAutoDriver extends Base{

    @Before
    public void setup() {
        System.setProperty("wdm.targetPath", "lib/drivers/auto/");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

}
