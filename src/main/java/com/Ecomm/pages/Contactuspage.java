package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contactuspage {
    WebDriver driver;

    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.name("message");
    By submitBtn = By.name("submit");
    By successMsg = By.xpath("//div[contains(text(),'Success!')]");

    public Contactuspage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }

    public String getSuccessMsg() {
        return driver.findElement(successMsg).getText();
    }
}