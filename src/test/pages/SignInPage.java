package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.data.UserData;

public class SignInPage extends BasePage {
    private By emailField = By.id("session_email");
    private By passwordField = By.id("session_password");
    private By commitButton = By.name("commit");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(UserData data) {
        sendKeys(emailField, data.getEmail());
        sendKeys(passwordField, data.getPassword());
        click(commitButton);
    }
}
