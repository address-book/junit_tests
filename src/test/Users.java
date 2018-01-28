package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.TestCase.assertEquals;

public class Users extends Base {

    @Test
    public void login() throws InterruptedException {
        browser.get("http://address-book-example.herokuapp.com");

        browser.findElement(By.cssSelector("a[data-test=sign-in]")).click();

        String email = "techwell@example.com";

        Wait fluentWait = new FluentWait(browser)
                .withTimeout(5, SECONDS)
                .pollingEvery(500, MICROSECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement emailElement = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver browser) {
                return browser.findElement(By.id("session_email"));
            }
        });

        emailElement.sendKeys(email);
        browser.findElement(By.id("session_password")).sendKeys("password");
        browser.findElement(By.name("commit")).click();

        String user = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(email, user);
    }

}
