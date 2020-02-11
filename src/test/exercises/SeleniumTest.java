package test.exercises;

import test.base.SauceBase;
import org.openqa.selenium.By;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumTest extends SauceBase {

    @Test
    @DisplayName("Basic Test")
    void basicTest() {
        driver.get("https://www.saucedemo.com/");

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).click();

        // Add an assertion to make this a Test

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
}
