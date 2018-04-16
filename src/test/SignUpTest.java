package test;

import org.junit.Test;
import org.openqa.selenium.By;
import test.data.UserData;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends Base {

    @Test
    public void signUp() {
        driver.get("http://a.testaddressbook.com/sign_up");

        UserData newUser = UserData.randomUser();

        driver.findElement(By.id("user_email")).sendKeys(newUser.getEmail());
        driver.findElement(By.id("user_password")).sendKeys(newUser.getPassword());
        driver.findElement(By.name("commit")).click();

        assertEquals("Address Book", driver.getTitle());
    }

    @Test
    public void signUpFailBlankPassword() {
        driver.get("http://a.testaddressbook.com/sign_up");

        Map<String, String> requiredData = new HashMap<String, String>();
        requiredData.put("password", "");
        UserData newUser = new UserData(requiredData);

        driver.findElement(By.id("user_email")).sendKeys(newUser.getEmail());
        driver.findElement(By.id("user_password")).sendKeys(newUser.getPassword());
        driver.findElement(By.name("commit")).click();

        assertEquals("Address Book - Sign Up", driver.getTitle());
    }

}