package test;

import org.junit.Test;
import test.data.UserData;


public class SignInTest extends Base {

    @Test
    public void signInLink() {
        HomePage homePage = HomePage.visit(driver);
        homePage.getMenuButton().click();
        SignInPage signInPage = homePage.getSignInLink().click();

        signInPage.waitFor(homePage.getEmailElement);
        UserData userData = UserData.validUser();

        signInPage.getEmailElement().sendKeys(userData.getEmail());
        signInPage.getPasswordElement().sendKeys(userData.getPassword());
        signInPage.getSubmitButton().click();
        assertTrue(homePage.isElementPresent(homPage.getCurrentUser));
    }

}