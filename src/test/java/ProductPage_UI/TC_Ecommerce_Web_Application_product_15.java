package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Ecommerce_Web_Application_product_15 extends BaseTest {

    @Test
    public void verifyBrandBibaButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_15 - Verify BIBA Brand Button in Product Page");

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

        // Locate the BIBA Brand Button
        try {
            WebElement bibaBrandButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/Biba']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bibaBrandButton);
            Thread.sleep(500);

            // Try normal click first
            try {
                bibaBrandButton.click();
            } catch (Exception clickException) {
                // Use JavaScript click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bibaBrandButton);
            }

            test.pass("Successfully clicked on the BIBA Brand button.");

            // Add delay to visually verify button click
            Thread.sleep(3000);

        } catch (Exception e) {
            test.fail("Failed to click on BIBA Brand button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "BibaBrandButtonNotClickable"));
            Assert.fail("BIBA Brand button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
