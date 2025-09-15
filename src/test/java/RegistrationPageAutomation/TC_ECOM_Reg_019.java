package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_019 extends BaseTest {

    @Test
    public void verifyNameTextboxWithInvalidName() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_019 - Verify Name Text Box with Invalid Name");

        // Step 1: Open Automation Exercise website
        driver.get("https://www.automationexercise.com/");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on 'Signup / Login' button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Signup / Login')]")));
        signupLoginBtn.click();
        test.info("Clicked on Signup/Login button.");

        // Step 3: Enter INVALID Name and Email
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']")));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        // Invalid data as requested
        String invalidName = "12345";
        String email = "preddyvinod2@gmail.com";

        nameInput.clear();
        emailInput.clear();
        nameInput.sendKeys(invalidName);
        emailInput.sendKeys(email);
        test.info("Entered INVALID Name: " + invalidName + " and Email: " + email);

        // Step 4: Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
        test.info("Clicked on Signup button.");

        // Step 5: Verify that user is NOT able to register with invalid name
        boolean isEnterAccountInfoPage;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'Enter Account Information')]")));
            isEnterAccountInfoPage = true;
        } catch (Exception e) {
            isEnterAccountInfoPage = false;
        }

        // Expectation: should NOT navigate to Enter Account Information page
        Assert.assertFalse(isEnterAccountInfoPage,
                "User navigated to Enter Account Information page with invalid name!");

        // If the website shows an invalid name error message, capture it:
        WebElement errorMsg = null;
        try {
            errorMsg = driver.findElement(
                    By.xpath("//*[contains(text(),'Invalid name') or contains(text(),'valid name')]"));
        } catch (Exception e) {
            // no error message element found
        }

        if (errorMsg != null) {
            test.info("Error Message Displayed: " + errorMsg.getText());
            Assert.assertTrue(errorMsg.isDisplayed(), "Expected invalid name error message not displayed!");
            test.pass("PASS - Correct invalid name error message displayed: " + errorMsg.getText());
        } else {
            test.pass("PASS - User was not able to register with invalid name (no redirection).");
        }
    }
}
