package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_34 extends BaseTest {

    @Test
    public void verifyAddToCartButtonInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_34 - Verify Add to Cart Button in Product Page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/products");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 2: Wait until the first product's "Add to cart" button is visible
            WebElement addToCartBtn = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("(//a[contains(text(),'Add to cart')])[1]")));

            // Step 3: Click on Add to Cart button
            addToCartBtn.click();

            // Step 4: Wait for confirmation modal popup
            WebElement successModal = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.id("cartModal")));

            Assert.assertTrue(successModal.isDisplayed(), "Add to Cart confirmation modal not displayed!");
            test.pass("Successfully clicked Add to Cart button and confirmation appeared.");

        } catch (Exception e) {
            test.fail("Add to Cart button test failed due to exception: " + e.getMessage());
            Assert.fail("Add to Cart button test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
