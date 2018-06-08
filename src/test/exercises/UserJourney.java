package test.exercises;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.base.Base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserJourney extends Base {

    @Test
    public void journey() throws IOException, InterruptedException {
        driver.get("http://a.testaddressbook.com");

        // Add your first name and last name to the strings below

        String username = "user@example.com";
        String password = "password";
        String firstName = "Titus";
        String lastName = "Fortner";
        String streetAddress = "123 Main";
        String secondaryAddress = "Apt 1";
        String city = "Somewhere";
        String state = "TX";
        String zipCode = "78700";
        String fileLocation = "lib/smiley.gif";
        String birthday = "01/01/1980";
        String age = "38";
        String website = "http://example.com";
        String phone = "5128675309";
        String note = "This person is nice.";


        // Navigate to Sign In Page

        driver.findElement(By.cssSelector("[data-test=sign-in]")).click();

        // Submit Sign In Form

        driver.findElement(By.cssSelector("[data-test=email]")).sendKeys(username);
        driver.findElement(By.cssSelector("[data-test=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-test=submit]")).click();

        // Navigate to Address List Page

        driver.findElement(By.cssSelector("[data-test=addresses]")).click();

        // Navigate to New Address Page

        driver.findElement(By.cssSelector("[data-test=create]")).click();

        // Fill Out New Address Form & Submit

            // First Name, Last Name, Street Address, Secondary Address & City
        driver.findElement(By.id("address_first_name")).sendKeys(firstName);
        driver.findElement(By.id("address_last_name")).sendKeys(lastName);
        driver.findElement(By.id("address_street_address")).sendKeys(streetAddress    );
        driver.findElement(By.id("address_secondary_address")).sendKeys(secondaryAddress);
        driver.findElement(By.id("address_city")).sendKeys(city);

            // State (use Select class)
        WebElement stateElement = driver.findElement(By.id("address_state"));
        Select dropdown = new Select(stateElement);
        dropdown.selectByValue(state);

            // Zip Code, Country, Birthday, Age, Website
        driver.findElement(By.id("address_zip_code")).sendKeys(zipCode);
        driver.findElement(By.id("address_country_true")).click();
        driver.findElement(By.id("address_birthday")).sendKeys(birthday);
        driver.findElement(By.id("address_age")).sendKeys(age);
        driver.findElement(By.id("address_website")).sendKeys(website);

            // Upload File
        WebElement inputElement = driver.findElement(By.id("address_picture"));
        File file = new File(fileLocation);
        inputElement.sendKeys(file.getCanonicalPath());

            // Phone, Interest, Note
        driver.findElement(By.id("address_phone")).sendKeys(phone);
        driver.findElement(By.id("address_interest_dance")).click();
        driver.findElement(By.id("address_note")).sendKeys(note);

            // Submit Form
        driver.findElement(By.cssSelector("[data-test=submit]")).click();

        // Get ID from URL

        String id;
        String url = driver.getCurrentUrl();
        String pattern = "\\d+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(url);
        m.find();
        id = m.group(0);

        // Navigate to Edit Address Page

        driver.findElement(By.cssSelector("[data-test=edit]")).click();

        // Edit the First Name with newName and Submit

        String newName = "Jack";
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys(newName);
        driver.findElement(By.cssSelector("[data-test=submit]")).click();

        // Navigate to Address List Page

        driver.findElement(By.cssSelector("[data-test=list]")).click();

        // Get list of Destroy Link elements

        List<WebElement> destroyLinks = driver.findElements(By.cssSelector("[data-test^=destroy]"));

        // Iterate over the list to click the one matching the id we found above

        WebElement correctElement = null;

        for(WebElement element : destroyLinks)
        {
            if(element.getAttribute("data-test").contains(id)) {
                correctElement = element;
                correctElement.click();
                break;
            }
        }

        // Accept Alert

        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Wait for link to go away

        Thread.sleep(5000);
    }

}