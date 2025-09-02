package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignupPage {
    WebDriver driver;

    // Locators
    By nameField = By.name("name");
    By emailField = By.cssSelector("input[data-qa='signup-email']");
    By signupButton = By.xpath("//button[text()='Signup']");

    By dayDropdown = By.id("days");
    By monthDropdown = By.id("months");
    By yearDropdown = By.id("years");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Common Actions
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    // Dropdown Validations
    public boolean isDayDropdownDisplayed() {
        return driver.findElement(dayDropdown).isDisplayed();
    }

    public boolean isMonthDropdownDisplayed() {
        return driver.findElement(monthDropdown).isDisplayed();
    }

    public boolean isYearDropdownDisplayed() {
        return driver.findElement(yearDropdown).isDisplayed();
    }

    // Get Options Count
    public int getDayOptionsCount() {
        Select select = new Select(driver.findElement(dayDropdown));
        return select.getOptions().size();
    }

    public int getMonthOptionsCount() {
        Select select = new Select(driver.findElement(monthDropdown));
        return select.getOptions().size();
    }

    public int getYearOptionsCount() {
        Select select = new Select(driver.findElement(yearDropdown));
        return select.getOptions().size();
    }

    // Select Values
    public void selectDay(String day) {
        Select select = new Select(driver.findElement(dayDropdown));
        select.selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        Select select = new Select(driver.findElement(monthDropdown));
        select.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select select = new Select(driver.findElement(yearDropdown));
        select.selectByVisibleText(year);
    }

    // Get Selected Values
    public String getSelectedDay() {
        Select select = new Select(driver.findElement(dayDropdown));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedMonth() {
        Select select = new Select(driver.findElement(monthDropdown));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedYear() {
        Select select = new Select(driver.findElement(yearDropdown));
        return select.getFirstSelectedOption().getText();
    }
}
