package test;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertEquals;

public class AlertHandling extends Base {

    @Test
    public void alertText() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hello World');");

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();

        assertEquals("Hello World", alertText);
    }

}

