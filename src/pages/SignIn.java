package pages;

import data.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn extends Base {

    private By emailAddress = By.id("session_email");
    private By password = By.id("session_password");
    private By submit = By.name("commit");
    private By signUp = By.cssSelector("a[data-test=sign-up]");

    public static SignIn visit(WebDriver browser) {
        SignIn page = new SignIn(browser);
        page.visit("http://address-book-example.herokuapp.com/sign_in");
        return page;
    }

    public SignIn(WebDriver browser) {
        this.browser = browser;
    }

    public void signInUser(UserData data) {
        sendKeys(emailAddress, data.getEmailAddress());
        sendKeys(password, data.getPassword());
        click(submit);
    }

}
