package test;

import org.junit.Test;
import test.data.UserData;


public class SignInTest extends Base {

    @Test
    public void signInLink() {
        HomePage homePage = HomePage.visit(driver);
        SignInPage signInPage = homePage.navigateToSignIn();

        signInPage.signIn(UserData.validUser());

        assertTrue(homePage.isSignedIn());
    }

}