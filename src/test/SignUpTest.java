package test;

import org.junit.Test;
import org.openqa.selenium.By;
import test.data.UserData;

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

}