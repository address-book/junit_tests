package test.user;

import org.junit.Test;
import org.openqa.selenium.By;
import test.Base;

import static org.junit.Assert.assertEquals;

public class SignIn extends  Base {

    @Test
    public void signIn() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        String email = "techwell@example.com";
        String password = "password";

        driver.findElement(By.id("session_email")).sendKeys(email);
        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();

        By currentUser = By.cssSelector("span[data-test=current-user]");
        String user = driver.findElement(currentUser).getText();

        assertEquals(email, user);
    }

}