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

    private final By homeButton = By.xpath("//a[contains(text(),'Home')]");
    private final By productButton = By.xpath("//a[contains(text(),'Products')]");
    private final By cartButton = By.xpath("//a[contains(text(),'Cart')]");
    private final By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By apiTestingButton = By.xpath("//a[contains(text(),'API Testing')]");
    private final By videoTutorialsButton = By.xpath("//a[contains(text(),'Video Tutorials')]");
    private final By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");
    private final By scrollBar = By.tagName("body");
    private final By logo = By.xpath("//div[@class='logo pull-left']/a/img");
    private final By womenDropdown = By.xpath("//a[contains(text(),'Women')]");
    private final By subscriptionTextBox = By.id("susbscribe_email");
    private final By subscriptionArrowButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//div[@class='alert-success alert']");
    private final By orangeHomeButton = By.xpath("//a[contains(text(),'Continue On Home') or contains(text(),'Home')]");
    private final By proceedToCheckoutBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private final By cartItems = By.xpath("//tr[contains(@id,'product')]");
    private final By removeFromCartBtn = By.xpath("//a[@class='cart_quantity_delete']");
    public final By cartCount = By.xpath("//span[@id='cart_quantity']");
    private final By topArrowButton = By.id("scrollUp");

    private final By addBlueTopButton = By.xpath("//a[@data-product-id='1']");
    private final By viewCartInModal = By.xpath("//u[contains(text(),'View Cart')]");
    private final By blueTopInCart = By.xpath("//a[contains(text(),'Blue Top')]");

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

    public void addBlueTopToCart() {
        driver.findElement(addBlueTopButton).click();
    }

    public void clickViewCartInModal() {
        driver.findElement(viewCartInModal).click();
    }

    public boolean isBlueTopDisplayedInCart() {
        return driver.findElements(blueTopInCart).size() > 0;
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

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
