package test;
import pages.*;
import data.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AddressBook extends Base {

    @Test
    public void addressCRUDFlow() {
        SignUp signUp = SignUp.visit(browser);

        UserData userData = new UserData();
        signUp.createUser(userData);

        HomePage homePage = new HomePage(browser);
        assertEquals(userData.getEmailAddress(), homePage.currentUser());

        homePage.signOut();

        assertTrue(homePage.isSignedOut());

        SignIn signIn = new SignIn(browser);

        signIn.signInUser(userData);
        assertEquals(userData.getEmailAddress(), homePage.currentUser());

        AddressData addressData = new AddressData();

        AddressNew addressNew = AddressNew.visit(browser);
        addressNew.createAddress(addressData);

        AddressShow addressShow = new AddressShow(browser);

        assertTrue(addressShow.hasCreateMessage());
        assertTrue(addressShow.isValidAddress(addressData));
        String addressID = addressShow.getID();

        AddressData editAddressData = new AddressData();

        AddressEdit addressEdit = AddressEdit.visit(browser, addressID);
        addressEdit.editAddress(editAddressData);

        assertTrue(addressShow.hasEditMessage());
        assertTrue(addressShow.isValidAddress(editAddressData));

        AddressList addressList = AddressList.visit(browser);
        addressList.deleteAddress();

        assertTrue(addressList.hasDeleteMessage());
        assertTrue(addressList.isEmpty());
    }

}