package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class HomePage {
        private WebDriver driver;

        private By user = By.cssSelector("[data-test=current-user]");

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        public Boolean isSignedIn() {
            return driver.findElements(user).size() > 0;
        }
    }
