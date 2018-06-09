package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.data.*;

public class SignInPage {
    private WebDriver driver;

    private By emailField = By.id("session_email");
    private By passwordField = By.id("session_password");
    private By commitButton = By.name("commit");
    private By error = By.className("alert-notice");

    public static SignInPage visit(WebDriver driver) {
        SignInPage page = new SignInPage(driver);
        driver.get("http://a.testaddressbook.com/sign_in/");
        return page;
    }

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(User data) {
        fillForm(data);
    }

    public void signInUnsuccessfully(User data) {
        fillForm(data);
    }

    public Boolean hasErrorMessage() {
        return driver.findElements(error).size() > 0;
    }

    private void fillForm(User data) {
        driver.findElement(emailField).sendKeys(data.getEmail());
        driver.findElement(passwordField).sendKeys(data.getPassword());
        driver.findElement(commitButton).click();
    }
}
