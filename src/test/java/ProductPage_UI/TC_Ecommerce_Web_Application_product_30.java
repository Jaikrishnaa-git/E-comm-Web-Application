package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_30 extends BaseTest {

    @Test
    public void verifySubscriptionTextBoxInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_30 - Verify Subscription Textbox in Product Page");

        try {
            // Step 1: Open the Product Page
            driver.get("https://automationexercise.com/products");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            test.pass("Navigated to Product Page successfully.");

            // Step 2: Locate the subscription text box
            WebElement subscriptionBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("susbscribe_email")));
            subscriptionBox.click();
            subscriptionBox.sendKeys("testemail@example.com");
            test.pass("Entered email successfully into subscription textbox.");

            // Step 3: Click on Subscribe button
            WebElement subscribeBtn = driver.findElement(By.id("subscribe"));
            subscribeBtn.click();
            test.pass("Clicked on Subscribe button.");

            // Step 4: Validate confirmation message
            WebElement successMsg = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='alert-success alert']")));
            Assert.assertTrue(successMsg.isDisplayed(), "Subscription confirmation message not displayed!");
            test.pass("Subscription confirmation message displayed successfully.");

        } catch (Exception e) {
            test.fail("Subscription textbox test failed.");
            Assert.fail("Exception occurred while verifying subscription textbox: " + e.getMessage());
        } finally {
            // Step 5: Close Browser
            driver.quit();
            test.info("Browser closed after test execution.");
        }
    }
}
