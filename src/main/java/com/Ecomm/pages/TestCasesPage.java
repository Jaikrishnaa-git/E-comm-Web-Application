package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    WebDriver driver;

    By testCasesLink = By.linkText("Test Cases");
    By header = By.xpath("//b[contains(text(),'Test Cases')]");

    
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTestCasesLink() {
        driver.findElement(testCasesLink).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}