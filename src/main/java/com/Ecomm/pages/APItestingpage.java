package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class APItestingpage {
    WebDriver driver;
    By apiLink = By.linkText("API Testing");
    By header = By.xpath("//b[contains(text(),'API List for practice')]");
    public APItestingpage (WebDriver driver) {
        this.driver = driver;
    }


    public void clickApiTestingLink() {
        driver.findElement(apiLink).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}