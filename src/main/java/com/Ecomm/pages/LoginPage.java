package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

 
    private final By signupLoginLink = By.linkText("Signup / Login");
    private final By loginForm  = By.xpath("//form[@action='/login']");
    private final By signupForm = By.xpath("//form[@action='/signup']");

    private final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private final By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By logoutLink = By.linkText("Logout");
    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

  
    public void openLoginPage() {
        driver.findElement(signupLoginLink).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
    }

   
    public boolean isLoginFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

 
    public boolean isSignupFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupForm)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    public void loginCredentials(String email,String password)
    {
    		driver.findElement(loginEmail).sendKeys(email);
    		driver.findElement(loginPassword).sendKeys(password);
    		driver.findElement(loginButton).click();
    }
    public boolean logoutDisplayed()
    {
    	  return driver.findElement(logoutLink).isDisplayed();
    }

	public void logout() {
		driver.findElement(logoutLink).click();
	}
    public boolean isSignupVisible()
    {
    	 return driver.findElement(signupLoginLink).isDisplayed();
    }
}
