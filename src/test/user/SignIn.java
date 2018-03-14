package test.user;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.base.Base;
import test.data.UserData;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SignIn extends  Base {

    @Test
    public void signIn() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        HashMap validUser = (HashMap) new UserData().validUser();
        String email = (String) validUser.get("email");
        String password = (String) validUser.get("password");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("session_email"))).sendKeys(email);

        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();

        By currentUser = By.cssSelector("span[data-test=current-user]");
        String user = driver.findElement(currentUser).getText();

        assertEquals(email, user);
    }

}