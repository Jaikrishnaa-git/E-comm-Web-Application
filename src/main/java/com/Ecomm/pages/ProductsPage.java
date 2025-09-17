package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productsLink = By.xpath("//a[@href='/products']");
    private final By firstProductAddBtn = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private final By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By womensDropDown = By.xpath("//a[@href='#Women']");
    private final By mensDropDown = By.xpath("//a[@href='#Men']");
    private final By kidsDropDown = By.xpath("//a[@href='#Kids']");
    private final By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
    private final By product1 = By.xpath("//a[@href='/product_details/1']");
    private final By quantity = By.xpath("//input[@id='quantity']");
    private final By addToCart = By.xpath("//a[@data-product-id='1']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openProducts() {
        driver.get("https://www.automationexercise.com/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductAddBtn));
    }

    public void openProductpage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }

    public void addFirstProductToCart() {
        try {
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(firstProductAddBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);

            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
            continueBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyDropDown() {
        return driver.findElement(womensDropDown).isDisplayed() &&
               driver.findElement(mensDropDown).isDisplayed() &&
               driver.findElement(kidsDropDown).isDisplayed();
    }

    public boolean isBrandVisible() {
        try {
            return driver.findElement(poloBrand).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProduct() {
        try {
            WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(product1));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            wait.until(ExpectedConditions.elementToBeClickable(product));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean clickProduct2() throws InterruptedException {
        try {
            WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(product1));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            wait.until(ExpectedConditions.elementToBeClickable(product));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
            Thread.sleep(2000);  // wait for quantity field to appear
            return driver.findElement(quantity).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cartVisible() {
        try {
            return driver.findElement(addToCart).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
