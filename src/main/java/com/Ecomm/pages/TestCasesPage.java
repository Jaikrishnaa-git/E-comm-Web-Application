package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {
    WebDriver driver;
    WebDriverWait wait;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By testCasesLink = By.linkText("Test Cases");
    By header = By.xpath("//b[contains(text(),'Test Cases')]");

    // Correct locator for Test Case 1
    By testCase1 = By.xpath("//u[contains(text(),'Test Case 1: Register User')]");
    By testCase1Description = By.xpath("//div[@class='panel-body']/p");

    public void clickTestCasesLink() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    public String getHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    }

    public void clickTestCase1() {
        wait.until(ExpectedConditions.elementToBeClickable(testCase1)).click();
    }

    public String getTestCase1Description() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCase1Description)).getText();
    }
}