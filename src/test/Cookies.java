package test;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import test.base.Base;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

        driver.manage().addCookie(cookie);

        driver.get("http://a.testaddressbook.com/mypath");

        Cookie found = driver.manage().getCookieNamed("name");

        assertEquals("value", found.getValue());
        driver.manage().deleteAllCookies();

        assertFalse(driver.manage().getCookies().contains(found));
    }

}

