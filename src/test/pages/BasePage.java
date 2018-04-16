package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    WebDriver driver;

    void click(By locator) {
        while (true) {
            try {
                driver.findElement(locator).click();
                return;
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                waitForElement(locator);
            }
        }
    }

    void sendKeys(By locator, String text) {
        while (true) {
            try {
                driver.findElement(locator).sendKeys(text);
                return;
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                waitForElement(locator);
            }
        }
    }

    private void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    Boolean elementExists(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
