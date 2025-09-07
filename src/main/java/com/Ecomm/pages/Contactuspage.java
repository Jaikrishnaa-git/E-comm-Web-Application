package com.Ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Contactuspage {
    WebDriver driver;

    // ===== Functional Test Locators =====
    By automationExerciseButton = By.xpath("//a[@href='/']");
    By noteText = By.xpath("//h2[contains(text(),'Get In Touch')]");
    By feedbackText = By.xpath("//*[contains(text(),'Feedback for us') or contains(text(),'Feedback For Us')]");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageBox = By.id("message");
    By uploadFileButton = By.name("upload_file");
    By submitButton = By.name("submit");
    By feedbackLink = By.linkText("Feedback");

    // ===== UI Test Locators =====
    By homeButton = By.xpath("//a[@href='/']");
    By productsButton = By.xpath("//a[@href='/products']");
    By cartButton = By.xpath("//a[@href='/view_cart']");
    By signupLoginButton = By.xpath("//a[@href='/login']");
    By testCasesButton = By.xpath("//a[@href='/test_cases']");
    By apiTestingButton = By.xpath("//a[@href='/api_list']");
    By videoTutorialsButton = By.xpath("//a[@href='https://www.youtube.com/c/AutomationExercise']");
    By contactUsButton = By.xpath("//a[@href='/contact_us']");
    By scrollBar = By.tagName("body"); // generic
    By logo = By.xpath("//div[@class='logo pull-left']/a/img");
    By upArrow = By.id("scrollUp");  // #top button
    By subscriptionTextbox = By.id("susbscribe_email");
    By subscriptionArrowButton = By.id("subscribe");
    By emailLink = By.xpath("//a[contains(@href,'mailto:')]");

    public Contactuspage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Functional Actions =====
    public void clickAutomationExerciseButton() {
        driver.findElement(automationExerciseButton).click();
    }

    public boolean isNoteDisplayed() {
        return driver.findElement(noteText).isDisplayed();
    }

    public boolean isFeedbackDisplayed() {
        return driver.findElement(feedbackText).isDisplayed();
    }

    public void enterName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectField).clear();
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageBox).clear();
        driver.findElement(messageBox).sendKeys(message);
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickFeedbackLink() {
        driver.findElement(feedbackLink).click();
    }

    // ===== UI Actions =====
    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

    public void clickProductsButton() {
        driver.findElement(productsButton).click();
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

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickUpArrow() {
        driver.findElement(upArrow).click();
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionTextbox).clear();
        driver.findElement(subscriptionTextbox).sendKeys(email);
    }

    public void clickSubscriptionArrowButton() {
        driver.findElement(subscriptionArrowButton).click();
    }
    
    public String getSubscriptionEmailText() {
        return driver.findElement(subscriptionTextbox).getAttribute("value");
    }

    public boolean isEmailLinkPresent() {
        return driver.findElement(emailLink).isDisplayed();
    }

    // ===== Scroll Helpers =====
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
    
    public void scrollPage(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public long getScrollYPosition() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object value = js.executeScript("return window.pageYOffset;");
        return ((Number) value).longValue();  // avoid Double → Long cast issue
    }

    public boolean clickTopButtonAndValidate() {
        // Click #top button
        driver.findElement(upArrow).click();

        // Small wait to allow scrolling effect
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Validate if scrolled to top
        return getScrollYPosition() == 0;
    }
}
