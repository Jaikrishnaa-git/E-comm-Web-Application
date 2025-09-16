package com.Ecomm.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By signupLoginLink = By.linkText("Signup / Login");
    private final By newUserName  = By.xpath("//input[@data-qa='signup-name']");
    private final By newUserEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By signupBtn    = By.xpath("//button[@data-qa='signup-button']");

    private final By titleMr   = By.id("id_gender1");
    private final By titleMrs  = By.id("id_gender2");
    private final By firstName = By.id("first_name");
    private final By lastName  = By.id("last_name");
    private final By password  = By.id("password");

    private final By days   = By.id("days");
    private final By months = By.id("months");
    private final By years  = By.id("years");

    private final By newsletterChk = By.id("newsletter");
    private final By offersChk     = By.id("optin");

    private final By company  = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    private final By country  = By.id("country");
    private final By state    = By.id("state");
    private final By city     = By.id("city");
    private final By zipcode  = By.id("zipcode");
    private final By mobile   = By.id("mobile_number");

    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private final By accountCreatedMsg = By.xpath("//h2[@data-qa='account-created']");

    private final By addressError = By.id("address1-error"); // update this locator as per actual DOM

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean nameIsDisplayed() {
        return driver.findElement(newUserName).isDisplayed();
    }

    public boolean emailIsDisplayed() {
        return driver.findElement(newUserEmail).isDisplayed();
    }

    public boolean submitIsDisplayed() {
        return driver.findElement(signupBtn).isDisplayed();
    }

    public void clickSignupLoginLink() {
        driver.findElement(signupLoginLink).click();
    }

    public void openHome() {
        driver.get("https://www.automationexercise.com/");
    }

    public void goToSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newUserName));
    }

    public void startSignup(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newUserName)).clear();
        driver.findElement(newUserName).sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(newUserEmail)).clear();
        driver.findElement(newUserEmail).sendKeys(email);

        driver.findElement(signupBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
    }

    public void fillFullAccountForm(String title, String fName, String lName,
                                    String pwd, String day, String month, String year,
                                    boolean newsletter, boolean offers,
                                    String companyVal, String addr1, String addr2Val,
                                    String countryText, String stateVal, String cityVal,
                                    String zip, String mobileVal) {

        if (title.equalsIgnoreCase("Mr")) {
            driver.findElement(titleMr).click();
        } else {
            driver.findElement(titleMrs).click();
        }

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);

        driver.findElement(password).sendKeys(pwd);

        new Select(driver.findElement(days)).selectByVisibleText(day);
        new Select(driver.findElement(months)).selectByVisibleText(month);
        new Select(driver.findElement(years)).selectByVisibleText(year);

        if (newsletter) driver.findElement(newsletterChk).click();
        if (offers) driver.findElement(offersChk).click();

        driver.findElement(company).sendKeys(companyVal);
        driver.findElement(address1).sendKeys(addr1);
        driver.findElement(address2).sendKeys(addr2Val);

        new Select(driver.findElement(country)).selectByVisibleText(countryText);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(mobile).sendKeys(mobileVal);
    }

    private void removeAds() {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "var ads = document.querySelectorAll('iframe[id^=\"aswift_\"]'); " +
                "ads.forEach(ad => ad.remove());"
            );
            System.out.println("✅ Ads removed successfully");
        } catch (Exception e) {
            System.out.println("⚠️ No ads found to remove");
        }
    }

    public void submitCreateAccount() {
        removeAds();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        button.click();
    }

    public boolean isAccountCreated() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMsg));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getCityValidationMessage() {
        WebElement cityElement = driver.findElement(city);
        return cityElement.getAttribute("validationMessage");
    }

    public String getZipcodeValidationMessage() {
        WebElement zipcodeElement = driver.findElement(zipcode);
        return zipcodeElement.getAttribute("validationMessage");
    }

    public By getMobileLocator() {
        return mobile;
    }

    public void enterSignupDetails(String name, String email) {
        driver.findElement(newUserName).sendKeys(name);
        driver.findElement(newUserEmail).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    public String getAddressErrorMessage() {
        try {
            return driver.findElement(addressError).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isAddressValidationErrorVisible() {
        try {
            return driver.findElement(addressError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
