package com.Ecomm.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartLink          = By.linkText("Cart");
    private final By signupLoginLink   = By.linkText("Signup / Login");
    private final By testCasesLink     = By.linkText("Test Cases");
    private final By apiTestingLink    = By.linkText("API Testing");
    private final By productsLink      = By.xpath("//a[@href='/products']");  
    private final By contactUsLink     = By.linkText("Contact us");
    private final By videoTutorialsLink = By.linkText("Video Tutorials");  // ✅ Added locator
    private final By subscriptionBox = By.xpath("//input[@id='susbscribe_email']");
    private final By submitButton    = By.xpath("//button[@id='subscribe']");

    private final By homeBanner = By.id("slider-carousel");
    private final By sucessMessageOnSub = By.xpath("//div[@class='alert-success alert']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void open() {
        driver.get("https://www.automationexercise.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBanner));
    }

    public boolean isHomePageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(homeBanner)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
    }

    public void clickTestCases() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesLink)).click();
    }

    public void clickApiTesting() {
        wait.until(ExpectedConditions.elementToBeClickable(apiTestingLink)).click();
    }

    public void clickProducts() {  

        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }

    public void clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();
    }


    public void clickVideoTutorials() {   // ✅ Added method (no effect on other TCs)
        wait.until(ExpectedConditions.elementToBeClickable(videoTutorialsLink)).click();
    }

    
    public boolean isSubScriptionVisible()
    {
    		return driver.findElement(subscriptionBox).isDisplayed();
    }
    public boolean isSubmitVisble()
    {
    	    return driver.findElement(submitButton).isDisplayed();
    }

	public void enterSubsciptionMail(String email) throws InterruptedException {
		
		driver.findElement(subscriptionBox).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(submitButton).click();	
	}

	public boolean isSubSubmittedDisplayed() {
		 return driver.findElement(sucessMessageOnSub).isDisplayed();
	}
	

}
