package test.addresses;

import org.junit.Test;
import test.base.Base;
import test.data.User;
import test.pages.HomePage;
import test.pages.SignInPage;

import static org.junit.Assert.assertTrue;

public class CreateTest extends Base {

    @Test
    public void signInSuccessfully() {
        SignInPage signInPage = SignInPage.visit(driver);
        signInPage.signIn(User.validUser());

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isSignedIn());
    }

    @Test
    public void signInUnsuccessfully() {
        SignInPage signInPage = SignInPage.visit(driver);
        signInPage.signInUnsuccessfully(User.invalidUser());

        assertTrue(signInPage.hasErrorMessage());
    }

    @Test
    public void signInBlankPassword() {
        SignInPage signInPage = SignInPage.visit(driver);
        signInPage.signInUnsuccessfully(User.blankPassword());

        assertTrue(signInPage.hasErrorMessage());
    }

}
