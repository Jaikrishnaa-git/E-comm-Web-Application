package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_13 extends BaseTest {

    @Test
    public void verifyTopButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_13 - Verify #top Button in Product Page");

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

        // Scroll down to make #top button visible
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Locate and Click the #top button
        try {
            WebElement topButton = wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("scrollUp")));

            // Scroll into view just in case
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topButton);
            Thread.sleep(500);

            // Try normal click first
            try {
                topButton.click();
            } catch (Exception clickException) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", topButton);
            }

            test.pass("Successfully clicked on the #top button.");

            // Wait to visually confirm click before proceeding
            Thread.sleep(2000);

            // Assertion → Verify that page is scrolled to top
            Long scrollPosition = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
            Assert.assertEquals(scrollPosition, Long.valueOf(0), "#top button did not scroll to top!");

        } catch (Exception e) {
            test.fail("Failed to click on #top button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TopButtonNotClickable"));
            Assert.fail("#top button is not clickable: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
