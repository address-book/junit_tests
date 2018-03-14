package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SeleniumScript extends Base {

    @Test
    public void signInLink() {
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
    }

}