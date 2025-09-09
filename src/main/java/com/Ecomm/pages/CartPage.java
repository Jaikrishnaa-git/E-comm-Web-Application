package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    // Locators for Cart Page buttons & elements
    By cartLink = By.linkText("Cart");
    By homeButton = By.xpath("//a[contains(text(),'Home')]");
    By productButton = By.xpath("//a[contains(text(),'Products')]");
    By cartButton = By.xpath("//a[contains(text(),'Cart')]");
    By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    By apiTestingButton = By.xpath("//a[contains(text(),'API Testing')]");
    By videoTutorialsButton = By.xpath("//a[contains(text(),'Video Tutorials')]");
    By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");
    By scrollBar = By.tagName("body");   // page body to check scroll
    By logo = By.xpath("//div[@class='logo pull-left']/a/img");
    By womenDropdown = By.xpath("//a[contains(text(),'Women')]");
    By subscriptionTextBox = By.id("susbscribe_email");
    By subscriptionArrowButton = By.id("subscribe");
    By subscriptionSuccessMessage = By.xpath("//div[@class='alert-success alert']");
    By orangeHomeButton = By.xpath("//a[contains(text(),'Continue On Home') or contains(text(),'Home')]");
    By proceedToCheckoutBtn = By.xpath("//a[@class='btn btn-default check_out']");
    By cartItems = By.xpath("//tr[contains(@id,'product')]");
    By removeFromCartBtn = By.xpath("//a[@class='cart_quantity_delete']");
    public By cartCount = By.xpath("//span[@id='cart_quantity']");
    By topArrowButton = By.id("scrollUp");

    // Blue Top locators
    By addBlueTopButton = By.xpath("//a[@data-product-id='1']"); // Blue Top has product-id=1
    By viewCartInModal = By.xpath("//u[contains(text(),'View Cart')]");
    By blueTopInCart = By.xpath("//a[contains(text(),'Blue Top')]");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }

    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

    public void clickProductButton() {
        driver.findElement(productButton).click();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clickSignupLoginButton() {
        driver.findElement(signupLoginButton).click();
    }

    public void clickTestCasesButton() {
        driver.findElement(testCasesButton).click();
    }

    public void clickApiTestingButton() {
        driver.findElement(apiTestingButton).click();
    }

    public void clickVideoTutorialsButton() {
        driver.findElement(videoTutorialsButton).click();
    }

    public void clickContactUsButton() {
        driver.findElement(contactUsButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickWomenDropdown() {
        driver.findElement(womenDropdown).click();
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionTextBox).sendKeys(email);
    }

    public void clickSubscriptionArrowButton() {
        driver.findElement(subscriptionArrowButton).click();
    }

    public String getSubscriptionSuccessMessage() {
        return driver.findElement(subscriptionSuccessMessage).getText();
    }

    public String getEnteredSubscriptionText() {
        return driver.findElement(subscriptionTextBox).getAttribute("value");
    }

    public void clickOrangeHomeButton() {
        driver.findElement(orangeHomeButton).click();
    }

    // Blue Top actions
    public void addBlueTopToCart() {
        driver.findElement(addBlueTopButton).click();
    }

    public void clickViewCartInModal() {
        driver.findElement(viewCartInModal).click();
    }

    public boolean isBlueTopDisplayedInCart() {
        return driver.findElements(blueTopInCart).size() > 0;
    }

    // Cart actions
    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    // ✅ New helper method - just to check button presence/clickability
    public boolean isProceedToCheckoutButtonDisplayed() {
        WebElement button = driver.findElement(proceedToCheckoutBtn);
        return button.isDisplayed() && button.isEnabled();
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeFromCart() {
        driver.findElement(removeFromCartBtn).click();
    }

    public String getCartCountText() {
        return driver.findElement(cartCount).getText();
    }

    public void clickTopArrowButton() {
        driver.findElement(topArrowButton).click();
    }
}
