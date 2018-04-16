package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By signInLink = By.cssSelector("a[data-test=sign-in]");
    private By user = By.cssSelector("span[data-test=current-user]");

    public static HomePage visit(WebDriver driver) {
        HomePage page = new HomePage(driver);
        driver.get("http://a.testaddressbook.com");
        return page;
    }

    private HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage navigateToSignIn() {
        click(signInLink);
        return new SignInPage(driver);
    }

    public Boolean isSignedIn() {
        return elementExists(user);
    }
}
