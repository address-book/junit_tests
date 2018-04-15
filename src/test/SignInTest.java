package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class SignInTest extends Base {

    @Test
    public void signInLink() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement emailElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("session_email")));

        emailElement.sendKeys("user@example.com");
        driver.findElement(By.id("session_password")).sendKeys("password");
        driver.findElement(By.name("commit")).click();

        assertEquals("Address Book", driver.getTitle());
        assertEquals("http://a.testaddressbook.com/", driver.getCurrentUrl());

        By currentUser = By.cssSelector("span[data-test=current-user]");
        assertEquals(1, driver.findElements(currentUser).size());
        assertEquals("user@example.com", driver.findElement(currentUser).getText());
    }

}