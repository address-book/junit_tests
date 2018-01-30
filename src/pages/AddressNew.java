package pages;

import data.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressNew extends Base {

    private By firstName = By.id("address_first_name");
    private By lastName = By.id("address_last_name");
    private By streetAddress = By.id("address_street_address");
    private By secondaryAddress = By.id("address_secondary_address");
    private By city = By.id("address_city");
    private By state = By.id("address_state");
    private By zipCode = By.id("address_zip_code");
    private By submit = By.name("commit");

    public static AddressNew visit(WebDriver browser) {
        AddressNew page = new AddressNew(browser);
        page.visit("https://address-book-example.herokuapp.com/addresses/new");
        return page;
    }

    public AddressNew(WebDriver browser) {
        this.browser = browser;
    }

    public void createAddress(AddressData data) {
        sendKeys(firstName, data.getFirstName());
        sendKeys(lastName, data.getLastName());
        sendKeys(streetAddress, data.getStreetAddress());
        sendKeys(secondaryAddress, data.getSecondaryAddress());
        sendKeys(city, data.getCity());
        sendKeys(state, data.getState());
        sendKeys(zipCode, data.getZipCode());
        click(submit);
    }

}
