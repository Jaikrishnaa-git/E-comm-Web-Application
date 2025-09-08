package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Productpage {
    WebDriver driver;
    By productsLink = By.linkText("Products");
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By productName = By.xpath("//div[@class='productinfo text-center']/p");

    public Productpage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductsLink() {
        driver.findElement(productsLink).click();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public String getFirstProductName() {
        return driver.findElement(productName).getText();
    }
}