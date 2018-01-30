package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver browser;
    public static String url = "http://address-book-example.herokuapp.com";

    public By signInLink = By.cssSelector("a[data-test=sign-in]");
    public By user = By.cssSelector("span[data-test=current-user]");

    public static HomePage visit(WebDriver browser) {
        HomePage page = new HomePage(browser);
        page.visit();
        return page;
    }

    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public void visit() {
        this.browser.get(url);
    }

    public void followSignIn() {
        browser.findElement(signInLink).click();
    }

    public String currentUser() { return browser.findElement(user).getText(); }
}
