package test.authentication;

import test.base.*;
import test.data.*;
import test.pages.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogInTest extends Base {

    @Test
    public void signInSuccessfully() {
        HomePage homePage = HomePage.visit(driver);
        homePage.navigateToSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(User.validUser());

        assertTrue(homePage.isSignedIn());
    }

    @Test
    public void signInUnsuccessfully() {
        HomePage homePage = HomePage.visit(driver);
        homePage.navigateToSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(User.invalidUser());

        assertFalse(homePage.isSignedIn());
    }

}
