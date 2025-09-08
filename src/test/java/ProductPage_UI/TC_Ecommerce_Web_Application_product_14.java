package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Ecommerce_Web_Application_product_14 extends BaseTest {

    @Test
    public void verifyBrandPoloButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_14 - Verify Polo Brand Button in Product Page");

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

        // Locate the Polo Brand Button
        try {
            WebElement poloBrandButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/Polo']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", poloBrandButton);
            Thread.sleep(500);

            // Try normal click first
            try {
                poloBrandButton.click();
            } catch (Exception clickException) {
                // Use JavaScript click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", poloBrandButton);
            }

            test.pass("Successfully clicked on the Polo Brand button.");

            // Add delay to visually verify button click
            Thread.sleep(3000);

        } catch (Exception e) {
            test.fail("Failed to click on Polo Brand button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "PoloBrandButtonNotClickable"));
            Assert.fail("Polo Brand button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
