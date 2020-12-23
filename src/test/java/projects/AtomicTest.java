package test.java.projects;

import org.junit.Assert;
import org.junit.Test;
import test.java.SauceTestBase;
import test.java.pages.HomePage;
import test.java.pages.InventoryPage;

public class AtomicTest extends SauceTestBase {

    @Test
    public void login() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        InventoryPage inventoryPage =  homePage
                .login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isOnPage());
    }
}
