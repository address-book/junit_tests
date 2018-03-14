package test;

import org.junit.Test;
import org.openqa.selenium.By;
import test.base.Base;

public class LocateElement extends Base {

    @Test
    public void locateElementByFindElement() {
        driver.get("http://a.testaddressbook.com");

        driver.findElement(By.id("sign-in"));
        driver.findElement(By.cssSelector("a[data-test=sign-in]"));
        driver.findElement(By.linkText("Sign in"));
        driver.findElement(By.partialLinkText("Sign"));
        driver.findElement(By.xpath("//a[@data-test='sign-in']"));
    }

    @Test
    public void locateElementFromCollection() {
        driver.get("http://a.testaddressbook.com");

        driver.findElements(By.className("nav-item")).get(1);
        driver.findElements(By.tagName("a")).get(1);
    }

}