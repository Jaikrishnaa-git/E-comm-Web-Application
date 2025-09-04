package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    /** Open Test Cases Page */
    public void openTestCasesPage() {
        driver.get("https://automationexercise.com/");
        wait.until(ExpectedConditions.elementToBeClickable(testCasesMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesTitle));
    }

    /** Click a Test Case by name */
    public void clickTestCase(String testCaseName) {
        By caseLocator = By.xpath("//u[contains(text(),'" + testCaseName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(caseLocator)).click();
    }

    /** Click inside link of a Test Case by name */
    public void clickInsideLink(String testCaseName) {
        By insideLink = By.xpath("//u[contains(text(),'" + testCaseName + "')]/following::a[1]");
        wait.until(ExpectedConditions.elementToBeClickable(insideLink)).click();
    }

    /** ✅ Click Feedback Email on Test Cases page */
    public void clickFeedbackEmail() {
        By feedbackEmail = By.xpath("//u[normalize-space()='feedback@automationexercise.com']");
        wait.until(ExpectedConditions.elementToBeClickable(feedbackEmail)).click();
    }
}
