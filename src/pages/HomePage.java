package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {

    public By signOutLink = By.cssSelector("a[data-test=sign-out]");
    private By user = By.cssSelector("span[data-test=current-user]");

    public static HomePage visit(WebDriver browser) {
        HomePage page = new HomePage(browser);
        page.visit("http://address-book-example.herokuapp.com");
        return page;
    }

    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public void signOut() {
        click(signOutLink);
    }

    public Boolean isSignedOut() {
        return findElements(user).isEmpty();
    }

    public String currentUser() {
        return getText(user);
    }
}
