package com.Ecomm.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

   
    By cartLink = By.linkText("Cart");
    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By cartItems = By.xpath("//tr[contains(@id,'product')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }
}