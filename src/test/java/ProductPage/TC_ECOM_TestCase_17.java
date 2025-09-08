package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_17 extends BaseTest {

    @Test
    public void verifyViewProductButton() throws IOException {
        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_17 - Verify View Product Button in Product Page");

        // Open Home Page URL
        driver.get("https://www.automationexercise.com/");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Click on "Products" button
            WebElement productsButton = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[@href='/products']")));
            productsButton.click();
            test.pass("Clicked on the Products button successfully.");

            // Step 2: Wait for Products Page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));
            test.pass("Products page loaded successfully.");

            // Step 3: Locate the first "View Product" button
            WebElement viewProductButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/product_details/1') and contains(text(),'View Product')]")));

            // Scroll to the element before clicking
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProductButton);

            // Click on the View Product button
            viewProductButton.click();
            test.pass("Clicked on the 'View Product' button successfully.");

            // Step 4: Verify that product details page is opened
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-information']")));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("/product_details/1"),
                    "View Product button did not navigate to the expected product details page!");
            test.pass("Product details page opened successfully. Current URL: " + currentUrl);

        } catch (Exception e) {
            test.fail("Failed to click on the View Product button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "ViewProductButtonFailed"));
            Assert.fail("View Product button not working: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
