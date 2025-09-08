package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartLink = By.xpath("//a[@href='/view_cart']");
    private final By firstProductRow = By.xpath("//tr[contains(@id,'product')][1]");
    private final By firstProductName = By.xpath("//tr[contains(@id,'product')][1]//td[@class='cart_description']//a");
    private final By firstProductQuantity = By.xpath("//tr[contains(@id,'product')][1]//button[@class='disabled']");
    private final By removeFirstProductBtn = By.xpath("//tr[contains(@id,'product')][1]//a[@class='cart_quantity_delete']");
    private final By emptyCartMsg = By.xpath("//*[contains(text(),'Cart is empty')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openCart() {
        driver.findElement(cartLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductRow));
    }

    public String getFirstProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductName)).getText();
    }

    public String getFirstProductQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductQuantity)).getText();
    }

    public void removeFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(removeFirstProductBtn)).click();
    }

    
    public boolean isCartEmpty() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}