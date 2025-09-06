package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginpage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By signupLoginLink = By.linkText("Signup / Login");
    private final By loginForm  = By.xpath("//form[@action='/login']");
    private final By signupForm = By.xpath("//form[@action='/signup']");

    public loginpage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Step 2: Click on Signup/Login */
    public void openLoginPage() {
        driver.findElement(signupLoginLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
    }

    /** Step 3: Verify login form */
    public boolean isLoginFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /** Step 3: Verify signup form */
    public boolean isSignupFormVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupForm)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
