package test.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import test.Base;

import java.io.File;
import java.io.IOException;

public class FileUpload extends Base {

    @Test
    public void uploadFile() throws IOException {
        // Uncomment for Remote WebDriver
        // driver.setFileDetector(new LocalFileDetector());

        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement inputElement = driver.findElement(By.id("file-upload"));
        File file = new File("lib/drivers/chromedriver");
        inputElement.sendKeys(file.getCanonicalPath());
    }

}

