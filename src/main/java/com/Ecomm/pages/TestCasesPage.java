package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By testCasesMenu = By.xpath("//a[@href='/test_cases']");
    private final By testCasesTitle = By.xpath("//h2[normalize-space()='Test Cases']");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /** 🔧 Hide ads that block clicks */
    private void removeAds() {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "var ads = document.querySelectorAll('iframe[id^=\"aswift_\"]');" +
                "for(var i=0; i<ads.length; i++){ads[i].style.display='none';}"
            );
        } catch (Exception e) {
            System.out.println("⚠️ Ads not found or already hidden: " + e.getMessage());
        }
    }

    /** 🔧 Safe click with retry */
    private void safeClick(By locator) {
        removeAds(); // Hide ads first
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click(); // normal click
        } catch (ElementClickInterceptedException e) {
            System.out.println("⚠️ Click intercepted, retrying with JS...");
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    /** Open Test Cases Page */
    public void openTestCasesPage() {
        driver.get("https://automationexercise.com/");
        safeClick(testCasesMenu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesTitle));
    }

    /** Build safe XPath for Test Case names (handles quotes like 'Arrow') */
    private String buildSafeXPath(String testCaseName) {
        if (testCaseName.contains("'")) {
            // If it contains single quotes, wrap with double quotes
            return "//u[contains(text(),\"" + testCaseName + "\")]";
        } else {
            return "//u[contains(text(),'" + testCaseName + "')]";
        }
    }

    /** Click a Test Case by name */
    public void clickTestCase(String testCaseName) {
        String safeLocator = buildSafeXPath(testCaseName);
        safeClick(By.xpath(safeLocator));
    }

    /** Click inside link of a Test Case by name */
    public void clickInsideLink(String testCaseName) {
        String safeLocator;
        if (testCaseName.contains("'")) {
            safeLocator = "//u[contains(text(),\"" + testCaseName + "\")]/following::a[1]";
        } else {
            safeLocator = "//u[contains(text(),'" + testCaseName + "')]/following::a[1]";
        }
        safeClick(By.xpath(safeLocator));
    }

    /** ✅ Click Feedback Email on Test Cases page */
    public void clickFeedbackEmail() {
        By feedbackEmail = By.xpath("//u[normalize-space()='feedback@automationexercise.com']");
        safeClick(feedbackEmail);
    }

    /** Verify Test Cases page is visible */
    public boolean isPageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
