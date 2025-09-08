package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_8 extends BaseTest {

    @Test
    public void verifyBrandMadameButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_8 - Verify MADAME Brand Button in Product Page");

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

        // Locate the MADAME Brand Button
        try {
            WebElement madameBrandButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/Madame']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", madameBrandButton);
            Thread.sleep(500);

            // Try normal click first
            try {
                madameBrandButton.click();
            } catch (Exception clickException) {
                // Use JavaScript click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", madameBrandButton);
            }

            test.pass("Successfully clicked on the MADAME Brand button.");

            // Wait to visually confirm click before proceeding
            Thread.sleep(3000);

            // Assertion → Verify URL dynamically
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(
                currentUrl.contains("/brand_products/Madame"),
                "MADAME brand button did not navigate to expected URL! Found: " + currentUrl
            );

        } catch (Exception e) {
            test.fail("Failed to click on MADAME Brand button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "MadameBrandButtonNotClickable"));
            Assert.fail("MADAME Brand button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
