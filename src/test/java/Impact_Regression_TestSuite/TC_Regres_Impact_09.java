package Impact_Regression_TestSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Impact_09 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifyViewProductButton() throws IOException {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_09 - Verify View Product buttons for multiple products");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/products");
            test.info("Opened URL: https://automationexercise.com/products");

            // Step 2: Wait for products list to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));
            test.pass("Products page loaded successfully.");

            // Step 3: Define products to test (productName → productDetailsURL)
            Map<String, String> productsToTest = new LinkedHashMap<>();
            productsToTest.put("First Product", "/product_details/1");
            productsToTest.put("Men T-Shirt", "/product_details/2");
            productsToTest.put("Sleeveless Dress", "/product_details/3");

            // Step 4: Loop through products and test
            for (Map.Entry<String, String> entry : productsToTest.entrySet()) {
                String productName = entry.getKey();
                String productDetailsUrl = entry.getValue();

                test.info("Testing View Product button for: " + productName);

                // Locate View Product button dynamically by href
                WebElement viewProductBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@href,'" + productDetailsUrl + "') and contains(text(),'View Product')]")));

                // Scroll into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProductBtn);

                Assert.assertTrue(viewProductBtn.isDisplayed(), productName + " View Product button is not displayed");
                test.pass(productName + " - View Product button is visible");

                // Click View Product
                viewProductBtn.click();
                test.pass(productName + " - Clicked View Product button");

                // Verify product detail page loaded
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-information']")));
                String currentUrl = driver.getCurrentUrl();
                Assert.assertTrue(currentUrl.contains(productDetailsUrl),
                        productName + " - Product detail page did not load correctly!");
                test.pass(productName + " - Product detail page loaded successfully. URL: " + currentUrl);

                // Navigate back to Products page for next test
                driver.navigate().back();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));
                test.info("Navigated back to Products page for next product.");
            }

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "ViewProductButtonFailed"));
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
            test.info("Browser closed after execution.");
        }
    }
}
