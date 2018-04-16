package test.pages;

import org.openqa.selenium.*;
import test.elements.Element;

class BasePage {
    WebDriver driver;

    Element getElement(By locator) {
        return new Element(driver, locator);
    }

}
