package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SeleniumScript {

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getMethodName() + ": Failed");
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getMethodName() + ": Succeeded");
        }
    };

    @Test
    public void signInLink() {
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");

        // Start session (opens browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("http://a.testaddressbook.com");

        // Ensure browser in correct state when finding element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signIn =  wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("sign-in")));

        // Take action on element
        signIn.click();

        // Assert desired condition
        assertEquals("Address Book - Sign In", driver.getTitle());

        // Quit session (closes browser)
        driver.quit();
    }

}