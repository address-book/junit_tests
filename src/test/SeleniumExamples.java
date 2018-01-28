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

        assertEquals(linkText, partialLinkText);
        assertEquals(partialLinkText, css);
        assertEquals(css, xpath);
    }

}