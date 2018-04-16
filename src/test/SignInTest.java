package test;

import org.junit.Test;
import test.data.UserData;
import test.pages.*;

import static org.junit.Assert.assertTrue;


public class SignInTest extends Base {

    @Test
    public void signInLink() {
        HomePage homePage = HomePage.visit(driver);
        SignInPage signInPage = homePage.navigateToSignIn();

        signInPage.signIn(UserData.validUser());

        assertTrue(homePage.isSignedIn());
    }

}