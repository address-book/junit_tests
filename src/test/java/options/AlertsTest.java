package test.java.options;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsTest {
    WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();

    @Test
    public void accept() {
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.tagName("button")).click();

        driver.getTitle();
    }

    @Test
    public void acceptAndNotify() {
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.tagName("button")).click();

        try {
            driver.getTitle();
        } catch(UnhandledAlertException e) {
            // It was dismissed so it will work 2nd time
            driver.getTitle();
        }
    }

    @Test
    public void dismiss() {
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // This doesn't have a dismiss option so it isn't automatic
        driver.findElement(By.tagName("button")).click();
        driver.switchTo().alert().accept();

        // This does have a dismiss option
        driver.findElements(By.tagName("button")).get(1).click();
        driver.getTitle();
    }

    // Default Behavior
    @Test
    public void dismissAndNotify() {
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // This doesn't have a dismiss option so it isn't automatic
        driver.findElement(By.tagName("button")).click();
        driver.switchTo().alert().accept();

        driver.findElements(By.tagName("button")).get(1).click();

        try {
            driver.getTitle();
        } catch(UnhandledAlertException e) {
            // It was dismissed so it will work 2nd time
            driver.getTitle();
        }
    }

    @Test
    public void ignore() {
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.tagName("button")).click();

        try {
            driver.getTitle();
        } catch(UnhandledAlertException e) {
            // This doesn't have a dismiss option so it isn't automatic
            driver.switchTo().alert().accept();
        }
    }

    @Before
    public void manageDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
