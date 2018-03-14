package test.user;

import org.junit.Test;
import org.openqa.selenium.By;
import test.base.Base;
import test.data.UserData;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SignUp extends Base {

    @Test
    public void signUp() {
        driver.get("http://a.testaddressbook.com/sign_up");

        HashMap newUser = (HashMap) new UserData().newUser();
        String emailAddress = (String) newUser.get("emailAddress");
        String password = (String) newUser.get("password");

        driver.findElement(By.id("user_email")).sendKeys(emailAddress);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();

        assertEquals("Address Book", driver.getTitle());
    }

}