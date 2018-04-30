package test.authentication;

import org.junit.Test;
import org.openqa.selenium.By;
import test.Base;
import test.data.User;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends Base {

    @Test
    public void signUpSuccessfully() {
        driver.get("http://a.testaddressbook.com/sign_up");

        User newUser = User.randomUser();

        driver.findElement(By.id("user_email")).sendKeys(newUser.getEmail());
        driver.findElement(By.id("user_password")).sendKeys(newUser.getPassword());
        driver.findElement(By.name("commit")).click();

        assertEquals("Address Book", driver.getTitle());
    }

}
