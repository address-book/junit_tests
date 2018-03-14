package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public static HomePage visit(WebDriver driver) {
        HomePage page = new HomePage(driver);
        driver.get("http://a.testaddressbook.com");
        return page;
    }

    private HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSignIn() {
        driver.findElement(signInLink).click();
    }

    public Boolean isSignedIn(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement currentUser = wait.until(
                ExpectedConditions.presenceOfElementLocated(user));

        return currentUser.getText().equals(email);
    }
}
