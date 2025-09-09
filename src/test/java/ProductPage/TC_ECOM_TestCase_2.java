package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_2 extends BaseTest {

    @Test
    public void verifyWomenDropdownInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_2 - Verify Women Drop-down in Product Page");

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

        // Locate the Women Category Drop-down Button
        try {
            WebElement womenDropdown = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//a[contains(.,'Women')]")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", womenDropdown);
            Thread.sleep(500);

            // Try normal click first
            try {
                womenDropdown.click();
            } catch (Exception clickException) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", womenDropdown);
            }

            test.pass("Successfully clicked on the Women drop-down button.");
        } catch (Exception e) {
            test.fail("Failed to click on Women drop-down button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "WomenDropdownNotClickable"));
            Assert.fail("Women drop-down button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window
        driver.close();
    }
}
