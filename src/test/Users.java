package test;

import data.*;
import pages.*;

import data.UserData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Users extends Base {

    @Test
    public void signUpLogOutLogIn() {
        HomePage homePage = HomePage.visit(browser);

        // Sign Up

        homePage.followSignIn();

        WebDriverWait wait = new WebDriverWait(browser, 10);

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("a[data-test=sign-up]"))).click();

        UserData userData = new UserData();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("user_email"))).sendKeys(userData.getEmailAddress());

        browser.findElement(By.id("user_password")).sendKeys(userData.getPassword());
        browser.findElement(By.name("commit")).click();

        assertEquals(userData.getEmailAddress(), homePage.currentUser());

        // Log Out

        browser.findElement(By.cssSelector("a[data-test=sign-out]")).click();

        assertTrue(browser.findElements(By.cssSelector("span[data-test=current-user]")).isEmpty());

        // Log In

        browser.findElement(By.id("session_email")).sendKeys(userData.getEmailAddress());
        browser.findElement(By.id("session_password")).sendKeys(userData.getPassword());
        browser.findElement(By.name("commit")).click();

        String loggedInUser = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(userData.getEmailAddress(), loggedInUser);
    }

}
