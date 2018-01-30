package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    WebDriver browser;

    void click(By locator) {
        waitForElement(locator);
        findElement(locator).click();
    }

    String getText(By locator) {
        waitForElement(locator);
        return findElement(locator).getText();
    }

    void sendKeys(By locator, String text) {
        waitForElement(locator);
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        browser.switchTo().alert().accept();
    }

    private void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private WebElement findElement(By locator) {
        return browser.findElement(locator);
    }

    List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public void visit(String url) {
        this.browser.get(url);
    }

}
