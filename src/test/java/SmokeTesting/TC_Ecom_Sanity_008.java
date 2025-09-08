package SmokeTesting;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_Ecom_Sanity_008 extends BaseTest {

    @Test
    public void verifyAndValidateSubscription() {
        // Create Extent Report Test
        ExtentTest test = extent.createTest("TC_Ecom_Sanity_008 - Verify and Validate Subscription");

        // Get Browser Name from RemoteWebDriver
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        test.info("Browser launched: " + browserName);

        try {
            // Step 1: Open the Automation Exercise URL
            driver.get("https://www.automationexercise.com/");
            test.info("Opened Automation Exercise website");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 2: Wait until the subscription section is visible
            WebElement subscriptionSection = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Subscription']"))
            );

            if (subscriptionSection.isDisplayed()) {
                test.pass("Subscription section is visible on the page");
            } else {
                test.fail("Subscription section is NOT visible on the page");
            }

            // Step 3: Enter email in the subscription input box
            WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
            emailInput.clear();
            emailInput.sendKeys("vinodkumar12@gmail.com");
            test.info("Entered email: vinodkumar12@gmail.com");

            // Step 4: Click on the arrow button to subscribe
            WebElement arrowButton = driver.findElement(By.xpath("//button[@id='subscribe']//i"));
            arrowButton.click();
            test.info("Clicked on the subscription arrow button");

            // Step 5: Wait for the success message to appear
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(text(),'You have been successfully subscribed')]")
                    )
            );

            if (successMessage.isDisplayed()) {
                test.pass("PASS - 'You have been successfully subscribed!' message displayed successfully");
            } else {
                test.fail("FAIL - Subscription message not displayed");
            }

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
