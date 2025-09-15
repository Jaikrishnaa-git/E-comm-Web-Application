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
            
            driver.get("https://automationexercise.com/");
            test.info("Navigated to the Ecommerce Website");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("susbscribe_email")));   
            emailBox.clear();
            emailBox.sendKeys("vinod123"); 
            test.info("Entered invalid email: invalidEmail");

            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("subscribe")));   
            submitBtn.click();
            test.info("Clicked on Subscribe button");

      
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("subscribe_error")));
            Assert.assertTrue(errorMsg.isDisplayed(), "Error message is not displayed for invalid email!");
            test.pass("Invalid email submission correctly prevented.");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }
}