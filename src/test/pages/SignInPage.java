package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private By emailField = By.id("session_email");
    private By passwordField = By.id("session_password");
    private By commitButton = By.name("commit");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String email, String password) {
        sendKeys(emailField, email);
        sendKeys(passwordField, password);
        click(commitButton);
    }
}
