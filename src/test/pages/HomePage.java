package test.pages;

import org.openqa.selenium.WebDriver;

    public class HomePage {
        private WebDriver driver;

        public static HomePage visit(WebDriver driver) {
            HomePage page = new HomePage(driver);
            driver.get("http://a.testaddressbook.com");
            return page;
        }

        private HomePage(WebDriver driver) {
            this.driver = driver;
        }

        public void navigateToSignIn() {
            driver.findElement(signInLink).click();
        }

        public Boolean isSignedIn() {
            return driver.findElements(user).size() > 0;
        }
    }

