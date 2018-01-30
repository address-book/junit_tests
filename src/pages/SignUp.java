package pages;

import data.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp extends Base{
    private By emailAddress = By.id("user_email");
    private By password = By.id("user_password");
    private By submit = By.name("commit");

    public static SignUp visit(WebDriver browser) {
        SignUp page = new SignUp(browser);
        page.visit("http://address-book-example.herokuapp.com/sign_up");
        return page;
    }

    private SignUp(WebDriver browser) {
        this.browser = browser;
    }

    public void createUser(UserData data) {
        sendKeys(emailAddress, data.getEmailAddress());
        sendKeys(password, data.getPassword());
        click(submit);
    }

}
