package pages;

import data.AddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressShow extends Base {

    private By message = By.cssSelector("div[data-test='notice']");
    private By firstName = By.cssSelector("span[data-test='first_name']");
    private By lastName = By.cssSelector("span[data-test='last_name']");
    private By streetAddress = By.cssSelector("span[data-test='street_address']");
    private By secondaryAddress = By.cssSelector("span[data-test='secondary_address']");
    private By city = By.cssSelector("span[data-test='city']");
    private By state = By.cssSelector("span[data-test='state']");
    private By zipCode = By.cssSelector("span[data-test='zip_code']");

    public static AddressShow visit(WebDriver browser, String id) {
        AddressShow page = new AddressShow(browser);
        page.visit("https://address-book-example.herokuapp.com/addresses/" + id);
        return page;
    }

    public AddressShow(WebDriver browser) {
        this.browser = browser;
    }

    public boolean isValidAddress(AddressData data) {
        return getText(firstName).equals(data.getFirstName()) &&
                getText(lastName).equals(data.getLastName()) &&
                getText(streetAddress).equals(data.getStreetAddress()) &&
                getText(secondaryAddress).equals(data.getSecondaryAddress()) &&
                getText(city).equals(data.getCity()) &&
                getText(state).equals(data.getState()) &&
                getText(zipCode).equals(data.getZipCode());
    }

    public Boolean hasCreateMessage() {
        return getText(message).equals("Address was successfully created.");
    }

    public Boolean hasEditMessage() {
        return getText(message).equals("Address was successfully updated.");
    }

    public String getID() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(browser.getCurrentUrl());
        m.find();
        return m.group();
    }

}
