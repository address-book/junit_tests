package test;

import org.junit.Test;
import org.openqa.selenium.By;

public class SignInTest extends Base {

    @Test
    public void signInLink() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();
        driver.findElement(By.id("session_email")).
                sendKeys("user@example.com");
        driver.findElement(By.id("session_password")).
                sendKeys("password");
        driver.findElement(By.name("commit")).click();
    }

}