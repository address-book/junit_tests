package pages;

import data.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
    public WebDriver browser;
    public static String url = "http://address-book-example.herokuapp.com/sign_up";

    public By emailAddress = By.id("user_email");
    public By password = By.id("user_password");
    public By submit = By.name("commit");

    private WebDriverWait wait;

    public static SignUp visit(WebDriver browser) {
        SignUp page = new SignUp(browser);
        page.visit();
        return page;
    }

    public SignUp(WebDriver browser) {
        this.browser = browser;
    }

    public void visit() {
        this.browser.get(url);
    }

    public void createUser(UserData data) {
        wait = new WebDriverWait(this.browser, 10);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(emailAddress)).sendKeys(data.getEmailAddress());
        browser.findElement(password).sendKeys(data.getPassword());
        browser.findElement(submit).click();
    }

}
