package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class Users extends Base {

    @Test
    public void login() {
        browser.get("http://address-book-example.herokuapp.com");

        browser.findElement(By.cssSelector("a[data-test=sign-in]")).click();

        String email = "techwell@example.com";
        WebDriverWait wait = new WebDriverWait(browser, 10);

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("session_email"))).sendKeys(email);

        browser.findElement(By.id("session_password")).sendKeys("password");
        browser.findElement(By.name("commit")).click();

        String user = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(email, user);
    }

}
