package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class VideoTutorialsPage {
    WebDriver driver;
    By videoControlsIcon = By.linkText("Video Tutorials");

 
    public VideoTutorialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickVideoControls() {
        driver.findElement(videoControlsIcon).click();
    }

    public String switchToYouTubeTab() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        return driver.getCurrentUrl();
    }
}