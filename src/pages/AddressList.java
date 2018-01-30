package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressList extends Base {

    private By destroyLink = By.cssSelector("tbody td:nth-child(7) a");
    private By message = By.cssSelector("div[data-test='notice']");
    private By rows = By.cssSelector("tbody tr");


    public static AddressList visit(WebDriver browser) {
        AddressList page = new AddressList(browser);
        page.visit("http://address-book-example.herokuapp.com/addresses");
        return page;
    }

    public AddressList(WebDriver browser) {
        this.browser = browser;
    }

    public void deleteAddress() {
        click(destroyLink);
        acceptAlert();
    }

    public Boolean hasDeleteMessage() {
        return getText(message).equals("Address was successfully destroyed.");
    }

    public Boolean isEmpty() {
        return findElements(rows).isEmpty();
    }

}
