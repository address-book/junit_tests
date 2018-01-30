package test;

import pages.*;
import data.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.Assert.assertTrue;

public class Addresses extends Base {

    @Test
    public void createAddress() {
        SignUp.visit(browser).createUser(new UserData());

        AddressData addressData = new AddressData();

        AddressNew addressNew = AddressNew.visit(browser);
        addressNew.createAddress(addressData);

        AddressShow addressShow = new AddressShow(browser);
        assertTrue(addressShow.hasCreateMessage());
        assertTrue(addressShow.isValidAddress(addressData));
    }

    @Test
    public void editAddress() {
        SignUp.visit(browser).createUser(new UserData());

        AddressData addressData = new AddressData();

        AddressNew addressNew = AddressNew.visit(browser);
        addressNew.createAddress(addressData);
        AddressShow addressShow = new AddressShow(browser);
        String addressID = addressShow.getID();

        AddressData editAddressData = new AddressData();

        AddressEdit addressEdit = AddressEdit.visit(browser, addressID);
        addressEdit.editAddress(editAddressData);

        assertTrue(addressShow.hasEditMessage());
        assertTrue(addressShow.isValidAddress(editAddressData));
    }

    @Test
    public void deleteAddress() {
        SignUp.visit(browser).createUser(new UserData());

        AddressNew.visit(browser).createAddress(new AddressData());
        AddressList addressList = AddressList.visit(browser);

        addressList.deleteAddress();

        assertTrue(addressList.hasDeleteMessage());
        assertTrue(addressList.isEmpty());
    }

}