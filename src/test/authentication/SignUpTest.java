package test.authentication;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.base.Base;
import test.data.User;

import static junit.framework.TestCase.assertTrue;

public class SignUpTest extends Base {

    @Test
    public void signUpSuccessfully() {
        driver.get("http://a.testaddressbook.com/sign_up");

        User user = User.randomUser();
        String email = user.getEmail();
        String password = user.getPassword();

        WebDriverWait explicitWait = new WebDriverWait(driver, 20);

        WebElement emailElement = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user_email")));

        emailElement.sendKeys(email);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();

        By currentUser = By.cssSelector("span[data-test=current-user]");
        assertTrue(driver.findElements(currentUser).size() > 0);
    }

}
