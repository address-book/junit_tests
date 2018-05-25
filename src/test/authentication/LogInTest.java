package test.authentication;

import test.base.*;
import test.data.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogInTest extends Base {

    @Test
    public void signInSuccessfully() {
        HomePage homePage = HomePage.visit(driver);
        homePage.navigateToSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(User.validUser());

        assertTrue(homePage.isSignedIn());
    }

    @Test
    public void signInUnsuccessfully() {

        // Rewrite Test Declaratively

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
