package test.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {
    private WebDriver driver;
    protected By locator;
    private WebDriverWait wait;

    public Element(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void click() {
        while (true) {
            try {
                driver.findElement(locator).click();
                return;
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                waitForElement();
            }
        }
    }

    public void sendKeys(String text) {
        while (true) {
            try {
                driver.findElement(locator).sendKeys(text);
                return;
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                waitForElement();
            }
        }
    }

    private void waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Boolean exists() {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

