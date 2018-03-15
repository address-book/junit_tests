package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    WebDriver driver;

    void click(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    String getText(By locator) {
        waitForElement(locator);
        return driver.findElement(locator).getText();
    }

    void sendKeys(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    private void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
