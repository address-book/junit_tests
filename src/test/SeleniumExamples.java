package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertEquals;

public class SeleniumExamples extends Base {

    private WebDriver browser;

    @Before
    public void setup() {
        super.setup();
        browser = new ChromeDriver();
    }

    @After
    public void teardown() {
        browser.quit();
    }

    @Test
    public void navigateBrowser() {
        browser.get("http://address-book-example.herokuapp.com");

        assertEquals("AddressBook", browser.getTitle());
    }

}