package Impact_Regression_TestSuite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Impact_08 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifyAddToCartButton() throws IOException {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_08 - Verify Add to Cart button on All Products page");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Open Products page URL
            driver.get("https://automationexercise.com/products");
            test.info("Opened URL: https://automationexercise.com/products");

            // Step 2: Wait for products list to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));
            test.pass("Products page loaded successfully.");

            // Step 3: Locate "Add to Cart" button for first product (Laptop/Product 1)
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@class,'add-to-cart') and @data-product-id='1']")));

            // Scroll to element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

            Assert.assertTrue(addToCartButton.isDisplayed(), "Add to Cart button is not displayed for product 1");
            test.pass("Add to Cart button is visible for first product (Laptop)");

            // Step 4: Click Add to Cart button
            addToCartButton.click();
            test.pass("Clicked on Add to Cart button successfully.");

            // Step 5: Verify cart popup appears
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
            WebElement cartPopup = driver.findElement(By.id("cartModal"));
            Assert.assertTrue(cartPopup.isDisplayed(), "Cart popup did not appear after clicking Add to Cart");
            test.pass("Cart popup appeared successfully after adding product to cart.");

            // Step 6: Close popup (Continue Shopping button)
            WebElement continueShoppingBtn = cartPopup.findElement(By.xpath("//button[text()='Continue Shopping']"));
            continueShoppingBtn.click();
            test.info("Closed cart popup by clicking Continue Shopping.");

        } catch (Exception e) {
            test.fail("Failed while testing Add to Cart button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "AddToCartFailed"));
            Assert.fail("Add to Cart button test failed: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
            test.info("Browser closed after execution.");
        }
    }
}
