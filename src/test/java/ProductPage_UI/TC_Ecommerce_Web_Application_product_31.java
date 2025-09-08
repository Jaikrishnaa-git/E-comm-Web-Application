package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_31 extends BaseTest {

    @Test
    public void verifySubscriptionArrowButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_31 - Verify Subscription Arrow Button in Product Page");

        try {
            // Step 1: Open the Product Page
            driver.get("https://automationexercise.com/products");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            test.pass("Navigated to Product Page successfully.");

            // Step 2: Locate the subscription text box and enter email
            WebElement subscriptionBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("susbscribe_email")));
            subscriptionBox.sendKeys("arrowtest@example.com");
            test.pass("Entered email successfully into subscription textbox.");

            // Step 3: Locate and Click on Arrow Button (Subscribe button)
            WebElement arrowButton = driver.findElement(By.id("subscribe"));
            arrowButton.click();
            test.pass("Clicked on Subscription Arrow Button successfully.");

            // Step 4: Validate confirmation message
            WebElement successMsg = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='alert-success alert']")));
            Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not displayed!");
            test.pass("Subscription confirmation message displayed successfully after clicking arrow button.");

        } catch (Exception e) {
            test.fail("Subscription arrow button test failed.");
            Assert.fail("Exception occurred while verifying subscription arrow button: " + e.getMessage());
        } finally {
            // Step 5: Close Browser
            driver.quit();
            test.info("Browser closed after test execution.");
        }
    }
}
