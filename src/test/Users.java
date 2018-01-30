package test;

import data.*;
import pages.*;

import data.UserData;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Users extends Base {

    @Test
    public void signUp() {
        UserData userData = new UserData();
        SignUp.visit(browser).createUser(userData);

        HomePage homePage = new HomePage(browser);
        assertEquals(userData.getEmailAddress(), homePage.currentUser());
    }

    @Test
    public void SignOut() {
        SignUp.visit(browser).createUser(new UserData());
        HomePage homePage = new HomePage(browser);

        homePage.signOut();

        assertTrue(homePage.isSignedOut());
    }

    @Test
    public void SignIn() {
        SignUp signUp = SignUp.visit(browser);
        UserData userData = new UserData();
        signUp.createUser(userData);

        HomePage homePage = new HomePage(browser);
        homePage.signOut();

        SignIn signIn = SignIn.visit(browser);
        signIn.signInUser(userData);

        assertEquals(userData.getEmailAddress(), homePage.currentUser());
    }
}
