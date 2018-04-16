package test.examples;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import test.Base;

public class AlertHandling extends Base {

    @Test
    public void alertText() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello World');");

        Alert alert = driver.switchTo().alert();

        // "Hello World"
        alert.getText();

        // Close Alert
        alert.dismiss();
    }

}

