package test.exercise;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.base.Base;

import static junit.framework.TestCase.assertEquals;

public class Location extends Base {

    //
    // Exercise:
    // Fill in the Strings and Update the Indexes to get the tests to pass
    //

    @Before
    public void navigate() {
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void locateEmailField() {

        // Update these fields:

        String id = "session_email";
        String name = "session[email]";
        String className = "form-control";
        String tagName = "input";
        Integer tagIndex = 2;


        // Obfuscated way of getting the Email Field
        WebElement emailField = driver.findElements(By.xpath("//*")).get(30);

        // Assert correct element has been found withe the updated strings
        assertEquals(emailField, driver.findElement(By.id(id)));
        assertEquals(emailField, driver.findElement(By.name(name)));
        assertEquals(emailField, driver.findElement(By.className(className)));
        assertEquals(emailField, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

    @Test
    public void locateSignInButton() {

        // Update these fields:

        String name = "commit";
        String className = "btn";
        String tagName = "input";
        Integer tagIndex = 4;


        // Obfuscated way of getting the Sign in Button
        WebElement signInButton = driver.findElements(By.xpath("//*")).get(34);

        assertEquals(signInButton, driver.findElement(By.name(name)));
        assertEquals(signInButton, driver.findElement(By.className(className)));
        assertEquals(signInButton, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

    @Test
    public void locateSignUpLink() {

        // Update these fields:

        String linkText = "Sign up";
        String partialLinkText = "up";
        String tagName = "a";
        Integer tagIndex = 2;


        // Obfuscated way of getting the Sign Up Link
        WebElement signUpLink = driver.findElements(By.xpath("//*")).get(36);

        assertEquals(signUpLink, driver.findElement(By.linkText(linkText)));
        assertEquals(signUpLink, driver.findElement(By.partialLinkText(partialLinkText)));
        assertEquals(signUpLink, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

}