package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.data.User;

public class SignInPage {
    private WebDriver driver;

    private By emailField = By.id("session_email");
    private By passwordField = By.id("session_password");
    private By commitButton = By.name("commit");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(User data) {
        driver.findElement(emailField).sendKeys(data.getEmail());
        driver.findElement(passwordField).sendKeys(data.getPassword());
        driver.findElement(commitButton).click();
    }
}
