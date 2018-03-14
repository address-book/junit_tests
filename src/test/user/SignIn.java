package test.user;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import test.Base;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class SignIn extends  Base {

    @Test
    public void signIn() throws InterruptedException {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        String email = "techwell@example.com";
        String password = "password";

        Wait fluentWait = new FluentWait(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(500, MICROSECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement emailElement = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver browser) {
                return browser.findElement(By.id("session_email"));
            }
        });

        emailElement.sendKeys(email);
        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();

        By currentUser = By.cssSelector("span[data-test=current-user]");
        String user = driver.findElement(currentUser).getText();

        assertEquals(email, user);
    }

}