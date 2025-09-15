package APITesting_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_API_Testing_31 extends BaseTest {

    @Test
    public void verifyInvalidEmailSubmission() {
        ExtentTest test = extent.createTest("TC_Ecommerce_Web_Application_API_Testing_31 - Verify Invalid Email Submission");

        try {
            // Step 1: Open the main URL
            driver.get("https://automationexercise.com/");
            test.info("Navigated to the Ecommerce Website");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Step 2: Scroll down to subscription email field
            WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("susbscribe_email")));   // Subscription email input
            emailBox.clear();
            emailBox.sendKeys("vinod123"); // invalid email
            test.info("Entered invalid email: invalidEmail");

            // Step 3: Click on Subscribe button
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("subscribe")));   // Subscribe button
            submitBtn.click();
            test.info("Clicked on Subscribe button");

            // Step 4: Verify error message for invalid email
            // (AutomationExercise shows error inside a <form> area)
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("subscribe_error")));  // locator for error message
            Assert.assertTrue(errorMsg.isDisplayed(), "Error message is not displayed for invalid email!");
            test.pass("Invalid email submission correctly prevented.");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }
}
