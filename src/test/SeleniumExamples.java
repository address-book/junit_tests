package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void locateElement() {
        browser.get("http://address-book-example.herokuapp.com");

        WebElement linkText = browser.findElement(By.linkText("Sign in"));
        WebElement partialLinkText = browser.findElement(By.partialLinkText("Sign"));
        WebElement css = browser.findElement(By.cssSelector("a[data-test=sign-in]"));
        WebElement xpath = browser.findElement(By.xpath("//a[@data-test='sign-in']"));

        WebElement tag = browser.findElements(By.tagName("a")).get(1);
        WebElement name = browser.findElements(By.className("nav-item")).get(1);

        assertEquals(linkText, partialLinkText);
        assertEquals(partialLinkText, css);
        assertEquals(css, xpath);
        assertEquals(xpath, tag);
        assertEquals(tag, name);
    }

    @Test
    public void validateElement() {
        browser.get("http://address-book-example.herokuapp.com");

        By locator = By.cssSelector("a[data-test=sign-in]");
        WebElement signIn = browser.findElement(locator);

        assertEquals("sign-in", signIn.getAttribute("data-test"));
        assertEquals("a", signIn.getTagName());
        assertEquals("Sign in", signIn.getText());
    }

}