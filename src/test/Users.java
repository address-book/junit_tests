package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Users extends Base {

    @Test
    public void signUpLogOutLogIn() {
        browser.get("http://address-book-example.herokuapp.com");

        // Sign Up

        browser.findElement(By.cssSelector("a[data-test=sign-in]")).click();

        WebDriverWait wait = new WebDriverWait(browser, 10);

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("a[data-test=sign-up]"))).click();

        String email = "techwell@example.com";
        String password = "password";

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("user_email"))).sendKeys(email);

        browser.findElement(By.id("user_password")).sendKeys(password);
        browser.findElement(By.name("commit")).click();

        String signedUpUser = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(email, signedUpUser);

        // Log Out

        browser.findElement(By.cssSelector("a[data-test=sign-out]")).click();

        assertTrue(browser.findElements(By.cssSelector("span[data-test=current-user]")).isEmpty());

        // Log In

        browser.findElement(By.id("session_email")).sendKeys(email);
        browser.findElement(By.id("session_password")).sendKeys(password);
        browser.findElement(By.name("commit")).click();

        String loggedInUser = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(email, loggedInUser);
    }

}
