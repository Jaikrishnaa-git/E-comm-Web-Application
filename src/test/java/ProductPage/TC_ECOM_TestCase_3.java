package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_3 extends BaseTest {

    @Test
    public void verifyMenDropdownInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_3 - Verify Men Drop-down in Product Page");

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

        // Locate the Men Category Drop-down Button
        try {
            WebElement menDropdown = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[contains(.,'Men')]")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menDropdown);
            Thread.sleep(500);

            // Try normal click first
            try {
                menDropdown.click();
            } catch (Exception clickException) {
                // Use JavaScript click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menDropdown);
            }

            test.pass("Successfully clicked on the Men drop-down button.");

            // Add delay to visually verify dropdown click
            Thread.sleep(3000);

        } catch (Exception e) {
            test.fail("Failed to click on Men drop-down button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "MenDropdownNotClickable"));
            Assert.fail("Men drop-down button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
