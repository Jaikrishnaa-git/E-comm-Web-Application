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

public class TC_Ecommerce_Web_Application_API_Testing_30 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyValidEmailSubmission() {
        ExtentTest test = extent.createTest("TC_Ecommerce_Web_Application_API_Testing_30 - Verify Valid Email Submission");

        try {
            // Step 1: Open the main URL
            driver.get("https://automationexercise.com/");
            test.info("Navigated to the Ecommerce Website");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Step 2: Scroll down to subscription email field
            WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("susbscribe_email")));   // Correct locator for subscription email box
            emailBox.clear();
            emailBox.sendKeys("testuser@example.com");
            test.info("Entered valid email: testuser@example.com");

            // Step 3: Click on Submit button
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("subscribe")));   // Correct locator for subscribe button
            submitBtn.click();
            test.info("Clicked on Subscribe button");

            // Step 4: Verify success message
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("success-subscribe")));  // Correct locator for success message
            Assert.assertTrue(successMsg.isDisplayed(), "Success message is not displayed!");
            test.pass("Valid email submitted successfully");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }
}
