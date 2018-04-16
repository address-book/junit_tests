package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.data.UserData;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(UserData data) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement emailElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(emailField));

        emailElement.sendKeys(data.getEmail());
        driver.findElement(passwordField).sendKeys(data.getPassword());
        driver.findElement(commitButton).click();
    }
}
