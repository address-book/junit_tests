package test.authentication;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.Base;
import test.data.User;

import static junit.framework.TestCase.assertTrue;

public class LogInTest extends Base {

    @Test
    public void signInSuccessfully() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        User user = User.validUser();
        String email = user.getEmail();
        String password = user.getPassword();

        WebDriverWait explicitWait = new WebDriverWait(driver, 20);

        WebElement emailElement = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("session_email")));

        emailElement.sendKeys(email);
        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();

        By currentUser = By.cssSelector("span[data-test=current-user]");
        assertTrue(driver.findElements(currentUser).size() > 0);
    }

    @Test
    public void signInUnsuccessfully() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        User user = User.invalidUser();
        String email = user.getEmail();
        String password = user.getPassword();

        WebDriverWait explicitWait = new WebDriverWait(driver, 20);

        WebElement emailElement = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("session_email")));

        emailElement.sendKeys(email);
        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();

        By emailField = By.id("sign-in");
        assertTrue(driver.findElements(emailField).size() > 0);
    }

}
