package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.base.Base;

import static org.junit.Assert.assertEquals;

public class ElementInteraction extends Base {

    @Before
    public void navigate() {
        driver.get("http://a.testaddressbook.com");
    }

    @Test
    public void storeVariable() {
        // Take direct action
        driver.findElement(By.id("sign-in")).click();

        // Or store element in a variable
        // and take action on stored variable

        WebElement email = driver.findElement(By.id("session_email"));
        email.clear();
    }

    @Test
    public void elementActions() {
        driver.findElement(By.id("sign-in")).click();

        WebElement email = driver.findElement(By.id("session_email"));
        email.clear();
        email.sendKeys("techwell@example.com");

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("password");

        driver.findElement(By.tagName("form")).submit();
    }

    @Test
    public void elementInformation() {
        WebElement signIn = driver.findElement(By.id("sign-in"));

        String text = signIn.getText();
        String tagName = signIn.getTagName();
        String attribute = signIn.getAttribute("data-test");
        Boolean displayed = signIn.isDisplayed();
        Boolean enabled = signIn.isEnabled();

        assertEquals("Sign in", text);
        assertEquals("a", tagName);
        assertEquals("sign-in", attribute);
        assertEquals(true, displayed);
        assertEquals(true, enabled);
    }

}