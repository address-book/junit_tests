package test.user;

import org.junit.Test;
import test.base.Base;
import test.data.UserData;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SignIn extends Base {

    @Test
    public void signIn() {
        HomePage homePage = HomePage.visit(driver);
        homePage.navigateToSignIn();

        SignInPage signInPage = new SignInPage(driver);

        HashMap validUser = (HashMap) new UserData().validUser();
        String email = (String) validUser.get("email");
        String password = (String) validUser.get("password");

        signInPage.signIn(email, password);

        assertTrue(homePage.isSignedIn(email));
    }

}