package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class APItestingpage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By header = By.xpath("//*[contains(text(),'API List for practice')]");

    public APItestingpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verify page header
    public String getHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    }

    // Expand API dropdown (scroll into view to avoid interception)
    public void expandAPIDropdown(int apiNumber) {
        By dropdown = By.xpath("//a[@data-toggle='collapse' and @href='#collapse" + apiNumber + "']");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdown));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-150)"); // offset to avoid sticky ads
        element.click();
    }

    // Get content of expanded dropdown
    public String getAPIDropdownContent(int apiNumber) {
        By content = By.id("collapse" + apiNumber);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(content)).getText();
    }
}
