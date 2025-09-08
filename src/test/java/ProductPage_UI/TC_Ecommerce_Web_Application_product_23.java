package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_23 extends BaseTest {

    @Test
    public void verifyProductPageLoadsOnChrome() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_23 - Verify Product Page Loads on Chrome");

        try {
            // Step 1: Open Chrome & Navigate to Product Page
            driver.get("https://automationexercise.com/products");

            // Step 2: Explicit Wait for Product Page heading
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement productPageHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'All Products')]")));

            // Step 3: Validate Page Load
            Assert.assertTrue(productPageHeader.isDisplayed(), "Product Page did not load correctly.");
            test.pass("Product Page loaded successfully in Chrome.");

        } catch (Exception e) {
            test.fail("Failed to load Product Page. Exception: " + e.getMessage());
            Assert.fail("Exception occurred while verifying Product Page load: " + e.getMessage());
        } finally {
            // Step 4: Close the Browser
            driver.close();
        }
    }
}
