package test.user;

import org.junit.Test;
import org.openqa.selenium.By;
import test.base.Base;
import test.data.UserData;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void signUpFailBlankPassword() {
        driver.get("http://address-book-example.herokuapp.com/sign_up");

        Map<String, String> requiredData = new HashMap<String, String>();
        requiredData.put("password", "");
        HashMap newUser = (HashMap) new UserData().newUser(requiredData);

        String emailAddress = (String) newUser.get("emailAddress");
        String password = (String) newUser.get("password");

        driver.findElement(By.id("user_email")).sendKeys(emailAddress);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();

        assertEquals("Address Book - Sign Up", driver.getTitle());
    }

}