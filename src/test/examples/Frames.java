package test.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import test.Base;

public class Frames extends Base {

    @Test
    public void frameSwitching() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // "BOTTON"
        driver.switchTo().frame(1);

        // Move up one context
        driver.switchTo().parentFrame();

        // ""
        driver.switchTo().frame("frame-top");

        // "LEFT"
        driver.switchTo().frame("frame-left");

        // Move back to top context
        driver.switchTo().defaultContent();
    }

}

