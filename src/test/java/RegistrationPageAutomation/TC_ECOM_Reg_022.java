package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_022 extends BaseTest {

    @Test
    public void verifyPasswordTextboxWithInvalidPassword() throws InterruptedException {

        // Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_022 - Verify Password Text Box with Invalid Password");

        // Step 1: Open Automation Exercise website
        driver.get("https://www.automationexercise.com/");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on 'Signup / Login' button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Signup / Login')]")));
        signupLoginBtn.click();
        test.info("Clicked on Signup/Login button.");

        // Step 3: Enter Name = 12345 and a unique Email
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']")));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        String invalidName = "12345";
        String uniqueEmail = "invalidPass" + System.currentTimeMillis() + "@gmail.com";

        nameInput.clear();
        emailInput.clear();
        nameInput.sendKeys(invalidName);
        emailInput.sendKeys(uniqueEmail);
        test.info("Entered Name: " + invalidName + " and Email: " + uniqueEmail);

        // Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
        test.info("Clicked on Signup button.");

        // Step 4: Fill Account Information page with Password = 12345 (invalid)
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password")));
        passwordInput.clear();
        passwordInput.sendKeys("12345");
        test.info("Entered invalid password: 12345");

        // Fill required address details (minimum needed for submission)
        driver.findElement(By.id("first_name")).sendKeys("Peddamallu Vinod Kumar");
        driver.findElement(By.id("last_name")).sendKeys("Reddy");
        driver.findElement(By.id("company")).sendKeys("REVA UNIVERSITY");
        driver.findElement(By.id("address1")).sendKeys("Rukmini knowledge park , kattigenahalli");
        driver.findElement(By.id("address2")).sendKeys("Yelahanka , Banglore");

        // Country
        WebElement countryDropdown = driver.findElement(By.id("country"));
        countryDropdown.sendKeys("India");

        driver.findElement(By.id("state")).sendKeys("Karnataka");
        driver.findElement(By.id("city")).sendKeys("Banglore");
        driver.findElement(By.id("zipcode")).sendKeys("560064");
        driver.findElement(By.id("mobile_number")).sendKeys("08274743923");

        // Step 5: Click 'Create Account'
        WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountBtn.click();
        test.info("Clicked on Create Account button.");

        // Step 6: Verify that registration did NOT succeed
        Thread.sleep(3000); // wait for response

        // Simple check: if still on signup page or any error message present
        boolean isErrorDisplayed = driver.getPageSource().toLowerCase().contains("invalid")
                || driver.getCurrentUrl().toLowerCase().contains("signup");

        Assert.assertTrue(isErrorDisplayed,
                "User should NOT be able to register with invalid password but registration succeeded.");
        test.pass("PASS - Registration blocked for invalid password as expected");
    }
}
