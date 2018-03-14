package test;

import org.junit.Test;
import test.base.Base;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BrowserInteractions extends Base {

    @Test
    public void browserInformation() {
        driver.get("http://a.testaddressbook.com");

        String pageTitle = driver.getTitle();
        String pageUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource();

        assertEquals("http://a.testaddressbook.com/", pageUrl);
        assertEquals("Address Book", pageTitle);
        assertTrue(pageSource.contains("<h1>Welcome to Address Book</h1>"));
    }

    @Test
    public void browserNavigation() {
        driver.get("http://a.testaddressbook.com");

        driver.navigate().to("http://google.com");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
    }




}

