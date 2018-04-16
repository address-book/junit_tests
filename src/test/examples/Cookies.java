package test.examples;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import test.Base;

import java.util.Date;

public class Cookies extends Base {

    @Test
    public void cIsForCookie() {
        driver.get("http://a.testaddressbook.com");

        Cookie cookie = new Cookie.Builder("name", "value")
                .domain("a.testaddressbook.com")
                .expiresOn(new Date(2020, 10, 31))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath")
                .build();

        // Add
        driver.manage().addCookie(cookie);

        // Read
        driver.get("http://a.testaddressbook.com/mypath");
        driver.manage().getCookieNamed("name");

        // Delete All
        driver.manage().deleteAllCookies();
    }

}

