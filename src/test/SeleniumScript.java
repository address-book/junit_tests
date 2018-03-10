package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScript {

    @Test
    public void findElement() {
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");

        // Start session (opens browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("http://a.testaddressbook.com");

        // Find element
        driver.findElement(By.id("sign-in"));

        // Quit session (closes browser)
        driver.quit();
    }

}