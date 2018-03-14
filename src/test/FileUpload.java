package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;

import static org.junit.Assert.assertTrue;

public class FileUpload extends BaseRemote {

    @Test
    public void uploadFile() {
        driver.setFileDetector(new LocalFileDetector());
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement inputElement = driver.findElement(By.id("file-upload"));
        inputElement.sendKeys("lib/drivers/chromedriver");

        assertTrue(inputElement.getAttribute("value").contains("chromedriver"));
    }

}

