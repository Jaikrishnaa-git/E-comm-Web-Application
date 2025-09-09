package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Ecommerce_Web_Application_product_19 extends BaseTest {

    @Test
    public void verifyBrandBabyhugButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_19 - Verify BABYHUG Brand Button in Product Page");

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

        // Locate the BABYHUG Brand Button
        try {
            WebElement babyhugBrandButton = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[@href='/brand_products/Babyhug']")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", babyhugBrandButton);
            Thread.sleep(500);

            // Try normal click first
            try {
                babyhugBrandButton.click();
            } catch (Exception clickException) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", babyhugBrandButton);
            }

            test.pass("Successfully clicked on the BABYHUG Brand button.");

            // Wait to visually confirm click before proceeding
            Thread.sleep(3000);

            // Assertion → Verify URL dynamically
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(
                currentUrl.contains("/brand_products/Babyhug"),
                "BABYHUG brand button did not navigate to expected URL! Found: " + currentUrl
            );

        } catch (Exception e) {
            test.fail("Failed to click on BABYHUG Brand button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "BabyhugBrandButtonNotClickable"));
            Assert.fail("BABYHUG Brand button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
