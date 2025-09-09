package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_7 extends BaseTest {

    @Test
    public void verifyBrandHandMButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_7 - Verify H&M Brand Button in Product Page");

        // Open the Home Page URL
        driver.get("https://www.automationexercise.com/");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Locate and Click on the Products Button
        try {
            WebElement productsButton = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[@href='/products']")));
            productsButton.click();
            test.pass("Clicked on the Products button successfully.");
        } catch (Exception e) {
            test.fail("Failed to click on Products button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "ProductsButtonNotClickable"));
            Assert.fail("Products button is not clickable: " + e.getMessage());
        }

        // Locate the H&M Brand Button
        try {
            WebElement handmBrandButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/H&M']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", handmBrandButton);
            Thread.sleep(500);

            // Try normal click first
            try {
                handmBrandButton.click();
            } catch (Exception clickException) {
                // Use JavaScript click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", handmBrandButton);
            }

            test.pass("Successfully clicked on the H&M Brand button.");

            // Wait to visually confirm click before proceeding
            Thread.sleep(3000);

            // Fixing Assertion → Use "contains" instead of strict equals
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(
                currentUrl.contains("/brand_products/H&M"),
                "H&M brand button did not navigate to expected URL! Found: " + currentUrl
            );

        } catch (Exception e) {
            test.fail("Failed to click on H&M Brand button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "HandMBrandButtonNotClickable"));
            Assert.fail("H&M Brand button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
