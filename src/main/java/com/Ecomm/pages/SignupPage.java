package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;
    By signupLoginLink = By.linkText("Signup / Login");
    By signupName = By.name("name");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public boolean nameIsdisplayed()
	{
		return driver.findElement(signupName).isDisplayed();
	}
    
    public void clickSignupLoginLink() {
        driver.findElement(signupLoginLink).click();
    }
   
    public void enterSignupDetails(String name, String email) {
        driver.findElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        driver.findElement(signupBtn).click();
    }
}