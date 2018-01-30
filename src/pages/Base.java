package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    WebDriver browser;

    void click(By locator) {
        waitForElement(locator);
        browser.findElement(locator).click();
    }

    String getText(By locator) {
        waitForElement(locator);
        return browser.findElement(locator).getText();
    }

    void sendKeys(By locator, String text) {
        waitForElement(locator);
        browser.findElement(locator).sendKeys(text);
    }

    private void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void visit(String url) {
        this.browser.get(url);
    }

}
