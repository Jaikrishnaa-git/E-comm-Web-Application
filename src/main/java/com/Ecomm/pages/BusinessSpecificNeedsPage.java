package com.Ecomm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessSpecificNeedsPage {

    WebDriver driver;
    WebDriverWait wait;

    public BusinessSpecificNeedsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By testCasesLink = By.xpath("//a[@href='/test_cases']");
    private By testCasesHeader = By.xpath("//h2[@class='title text-center']");
    private By testCase1Link = By.xpath("//a[@href='/test_cases/1']");
    private By testCase1Description = By.xpath("//div[@class='panel-body']/p");

    By allTestCases = By.xpath("//div[@class='panel-heading']/h4/a");

    By apiTestingLink = By.xpath("//a[contains(text(),'API Testing')]");

    By apiListHeader = By.xpath("//b[contains(text(),'APIs List for practice')]");
    
    By videoTutorialsLink = By.xpath("//a[contains(text(),'Video Tutorials')]");

    public void clickOnTestCasesLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(testCasesLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
    }

    public String getTestCasesHeaderText() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader));
        return header.getText();
    }

    public void clickOnTestCase1() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(testCase1Link));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
    }

    public String getTestCase1Description() {
        WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(testCase1Description));
        return desc.getText();
    }
    
    public List<WebElement> getAllTestCases() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allTestCases));
    }

    public void clickOnApiTestingLink() {
        WebElement apiLink = wait.until(ExpectedConditions.elementToBeClickable(apiTestingLink));
        apiLink.click();
    }
    public String getAPIListHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(apiListHeader));
        return header.getText();
    }
    
    public void clickVideoTutorials() {
        wait.until(ExpectedConditions.elementToBeClickable(videoTutorialsLink)).click();
    }
}