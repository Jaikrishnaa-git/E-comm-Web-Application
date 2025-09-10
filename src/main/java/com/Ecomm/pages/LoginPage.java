package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By signupLoginLink = By.linkText("Signup / Login");
    private final By loginForm = By.xpath("//form[@action='/login']");
    private final By signupForm = By.xpath("//form[@action='/signup']");
    private final By emailField = By.xpath("//input[@data-qa='login-email']");
    private final By passwordField = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By loggedInUser = By.xpath("//a[contains(@href,'/logout')]");
    private final By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    private final By logoutLink = By.linkText("Logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openLoginPage() {
        driver.findElement(signupLoginLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginForm));
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

    public void enterEmail(String email) {
        try {
            WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
            emailElement.clear();
            emailElement.sendKeys(email);
        } catch (Exception e) {
            System.err.println("Error entering email: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
            passwordElement.clear();
            passwordElement.sendKeys(password);
        } catch (Exception e) {
            System.err.println("Error entering password: " + e.getMessage());
        }
    }

    public void clickLoginButton() {
        try {
            WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButtonElement.click();
        } catch (Exception e) {
            System.err.println("Error clicking login button: " + e.getMessage());
        }
    }

    public void loginCredentials(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        try {
            return driver.findElements(loggedInUser).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElements(errorMessage).size() > 0 &&
                   driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            if (isErrorMessageDisplayed()) {
                return driver.findElement(errorMessage).getText();
            }
            return "No error message found";
        } catch (Exception e) {
            return "Error retrieving message: " + e.getMessage();
        }
    }

    public boolean logoutDisplayed() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    public void logout() {
        try {
            if (isLoggedIn()) {
                WebElement logoutElement = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
                logoutElement.click();
            }
        } catch (Exception e) {
            System.err.println("Error during logout: " + e.getMessage());
        }
    }

    public boolean isSignupVisible() {
        return driver.findElement(signupLoginLink).isDisplayed();
    }
}
