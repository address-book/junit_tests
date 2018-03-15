package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver driver;

    private By emailField = By.id("session_email");
    private By passwordField = By.id("session_password");
    private By commitButton = By.name("commit");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement emailElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(emailField));

        emailElement.sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(commitButton).click();
    }
}
