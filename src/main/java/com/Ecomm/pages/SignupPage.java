package com.Ecomm.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Navigation
    private final By signupLoginLink = By.linkText("Signup / Login");

    // New User Signup section
    private final By newUserName  = By.xpath("//input[@data-qa='signup-name']");
    private final By newUserEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By signupBtn    = By.xpath("//button[@data-qa='signup-button']");

    // Account Information fields
    private final By firstName = By.id("first_name");
    private final By lastName  = By.id("last_name");
    private final By password  = By.id("password");

    private final By days   = By.id("days");
    private final By months = By.id("months");
    private final By years  = By.id("years");

    private final By newsletterChk = By.id("newsletter");
    private final By offersChk     = By.id("optin");

    private final By company  = By.id("company");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ---------------------------
    // Navigation
    // ---------------------------
    public void openHome() {
        driver.get("https://www.automationexercise.com/");
    }
    
    public void newUserName(String name) {
        driver.findElement(newUserName).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(newUserEmail).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupBtn).click();
    }

    public void goToSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newUserName));
    }

    public void startSignup(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newUserName)).clear();
        driver.findElement(newUserName).sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(newUserEmail)).clear();
        driver.findElement(newUserEmail).sendKeys(email);

        driver.findElement(signupBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
    }

    // ---------------------------
    // Dropdown Validations
    // ---------------------------
    public boolean isYearDropdownDisplayed() {
        return driver.findElement(years).isDisplayed();
    }

    public int getYearOptionsCount() {
        return new Select(driver.findElement(years)).getOptions().size();
    }

    public void selectYear(String year) {
        new Select(driver.findElement(years)).selectByVisibleText(year);
    }

    public String getSelectedYear() {
        return new Select(driver.findElement(years)).getFirstSelectedOption().getText();
    }

    public boolean isDayDropdownDisplayed() {
        return driver.findElement(days).isDisplayed();
    }

    public boolean isMonthDropdownDisplayed() {
        return driver.findElement(months).isDisplayed();
    }

    public void selectDay(String day) {
        new Select(driver.findElement(days)).selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(months)).selectByVisibleText(month);
    }

    public String getSelectedDay() {
        return new Select(driver.findElement(days)).getFirstSelectedOption().getText();
    }

    public String getSelectedMonth() {
        return new Select(driver.findElement(months)).getFirstSelectedOption().getText();
    }

    // ---------------------------
    // Checkbox Validations
    // ---------------------------
    public boolean isNewsletterCheckboxDisplayed() {
        return driver.findElement(newsletterChk).isDisplayed();
    }

    public void clickNewsletterCheckbox() {
        driver.findElement(newsletterChk).click();
    }

    public boolean isNewsletterCheckboxSelected() {
        return driver.findElement(newsletterChk).isSelected();
    }

    public boolean isOffersCheckboxDisplayed() {
        return driver.findElement(offersChk).isDisplayed();
    }

    public void clickOffersCheckbox() {
        driver.findElement(offersChk).click();
    }

    public boolean isOffersCheckboxSelected() {
        return driver.findElement(offersChk).isSelected();
    }

    // ---------------------------
    // First Name Validations
    // ---------------------------
    public void enterFirstName(String fname) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fname);
    }

    public String getFirstNameValue() {
        return driver.findElement(firstName).getAttribute("value");
    }

    // ---------------------------
    // Last Name Validations
    // ---------------------------
    public void enterLastName(String lname) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lname);
    }

    public String getLastNameValue() {
        return driver.findElement(lastName).getAttribute("value");
    }

    // ---------------------------
    // Company Validations
    // ---------------------------
    public void enterCompany(String comp) {
        driver.findElement(company).clear();
        driver.findElement(company).sendKeys(comp);
    }

    public String getCompanyValue() {
        return driver.findElement(company).getAttribute("value");
    }
}
