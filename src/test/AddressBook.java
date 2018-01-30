package test;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AddressBook extends Base {

    @Test
    public void addressCRUDFlow() {
        browser.get("http://address-book-example.herokuapp.com");

        // Sign Up

        browser.findElement(By.cssSelector("a[data-test=sign-in]")).click();

        WebDriverWait wait = new WebDriverWait(browser, 2);

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("a[data-test=sign-up]"))).click();

        Faker faker = new Faker();

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("user_email"))).sendKeys(email);

        browser.findElement(By.id("user_password")).sendKeys(password);
        browser.findElement(By.name("commit")).click();

        String signedUpUser = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(email, signedUpUser);

        // Log Out

        browser.findElement(By.cssSelector("a[data-test=sign-out]")).click();

        assertTrue(browser.findElements(By.cssSelector("span[data-test=current-user]")).isEmpty());

        // Log In

        browser.findElement(By.id("session_email")).sendKeys(email);
        browser.findElement(By.id("session_password")).sendKeys(password);
        browser.findElement(By.name("commit")).click();

        String loggedInUser = browser.findElement(By.cssSelector("span[data-test=current-user]")).getText();

        assertEquals(email, loggedInUser);

        // Create Address

        browser.findElement(By.cssSelector("a[data-test='addresses']")).click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("a[data-test='create']"))).click();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String streetAddress = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.address().zipCode();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("address_first_name"))).sendKeys(firstName);

        browser.findElement(By.id("address_last_name")).sendKeys(lastName);
        browser.findElement(By.id("address_street_address")).sendKeys(streetAddress);
        browser.findElement(By.id("address_city")).sendKeys(city);
        browser.findElement(By.id("address_state")).sendKeys(state);
        browser.findElement(By.id("address_zip_code")).sendKeys(zipCode);

        browser.findElement(By.cssSelector("input[data-test='submit']")).click();

        String createMessage = browser.findElement(By.cssSelector("div[data-test='notice']")).getText();

        assertEquals("Address was successfully created.", createMessage);

        assertEquals(firstName, browser.findElement(By.cssSelector("span[data-test='first_name']")).getText());
        assertEquals(lastName, browser.findElement(By.cssSelector("span[data-test='last_name']")).getText());
        assertEquals(streetAddress, browser.findElement(By.cssSelector("span[data-test='street_address']")).getText());
        assertEquals(city, browser.findElement(By.cssSelector("span[data-test='city']")).getText());
        assertEquals(state, browser.findElement(By.cssSelector("span[data-test='state']")).getText());
        assertEquals(zipCode, browser.findElement(By.cssSelector("span[data-test='zip_code']")).getText());

        // Edit Address

        browser.findElement(By.cssSelector("a[data-test='list']")).click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("tbody td:nth-child(6) a"))).click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("address_first_name"))).clear();

        String editedFirst = faker.name().firstName();
        String editedLast = faker.name().lastName();

        browser.findElement(By.id("address_first_name")).sendKeys(editedFirst);

        browser.findElement(By.id("address_last_name")).clear();
        browser.findElement(By.id("address_last_name")).sendKeys(editedLast);

        browser.findElement(By.cssSelector("input[data-test='submit']")).click();

        String editMessage = browser.findElement(By.cssSelector("div[data-test='notice']")).getText();

        assertEquals("Address was successfully updated.", editMessage);

        assertEquals(editedFirst, browser.findElement(By.cssSelector("span[data-test='first_name']")).getText());
        assertEquals(editedLast, browser.findElement(By.cssSelector("span[data-test='last_name']")).getText());
        assertEquals(streetAddress, browser.findElement(By.cssSelector("span[data-test='street_address']")).getText());
        assertEquals(city, browser.findElement(By.cssSelector("span[data-test='city']")).getText());
        assertEquals(state, browser.findElement(By.cssSelector("span[data-test='state']")).getText());
        assertEquals(zipCode, browser.findElement(By.cssSelector("span[data-test='zip_code']")).getText());

        // Delete Address

        browser.findElement(By.cssSelector("a[data-test='list']")).click();

        String foundFirst = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.tagName("td"))).getText();

        assertEquals(editedFirst, foundFirst);
        assertEquals(editedLast, browser.findElements(By.tagName("td")).get(1).getText());

        browser.findElement(By.cssSelector("td:nth-child(7) a")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        browser.switchTo().alert().accept();

        String deleteMessage = browser.findElement(By.cssSelector("div[data-test='notice']")).getText();

        assertEquals("Address was successfully destroyed.", deleteMessage);

        assertTrue(browser.findElements(By.cssSelector("tbody tr")).isEmpty());
    }

}