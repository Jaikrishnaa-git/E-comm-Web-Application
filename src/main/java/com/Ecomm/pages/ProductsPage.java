package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By productsLink = By.xpath("//a[@href='/products']");
    private final By firstProductAddBtn = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private final By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Open Products Page */
    public void openProducts() {
        driver.get("https://www.automationexercise.com/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductAddBtn));
    }

    /** Add first product to cart safely */
    public void addFirstProductToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(firstProductAddBtn));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);

        // Click using JavaScript (bypass ad overlay issue)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);

        // Handle popup "Continue Shopping"
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
            continueBtn.click();
        } catch (Exception e) {
            // If popup doesn’t appear, ignore
        }
    }
}
