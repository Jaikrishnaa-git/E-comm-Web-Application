package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;

    // Locators
    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By signupForm = By.xpath("//form[@action='/signup']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
<<<<<<< HEAD
    
    public boolean nameIsdisplayed()
	{
		return driver.findElement(signupName).isDisplayed();
	}
    public boolean emailIsdisplayed()
	{
		return driver.findElement(signupEmail).isDisplayed();
	}
    public boolean submitIsdisplayed()
	{
		return driver.findElement(signupBtn).isDisplayed();
	}
    
    public void clickSignupLoginLink() {
        driver.findElement(signupLoginLink).click();
    }
   
    public void enterSignupDetails(String name, String email) {
=======

    public void enterSignupName(String name) {
        driver.findElement(signupName).clear();
>>>>>>> 77bb121 (2025sep8 project)
        driver.findElement(signupName).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(signupEmail).clear();
        driver.findElement(signupEmail).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public boolean isSignupPageStillDisplayed() {
        return driver.findElement(signupForm).isDisplayed();
    }
}
