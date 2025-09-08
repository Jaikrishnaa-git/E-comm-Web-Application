package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_24 {

    WebDriver driver;

    @Test
    public void verifyProductPageLoadsOnEdge() throws IOException {

        // Start Extent Report Test
        // Not extending BaseTest here since we want Edge specifically
        com.aventstack.extentreports.ExtentReports extent = new com.aventstack.extentreports.ExtentReports();
        com.aventstack.extentreports.ExtentTest test = extent.createTest("TC_Ecommerce_Web_Application_product_24 - Verify Product Page Loads on Edge");

        try {
            // Step 1: Launch Edge browser
            driver = new EdgeDriver();

            // Step 2: Navigate to Product Page
            driver.get("https://automationexercise.com/products");

            // Step 3: Explicit wait for Product Page heading
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement productPageHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'All Products')]")));

            // Step 4: Validate Product Page load
            Assert.assertTrue(productPageHeader.isDisplayed(), "Product Page did not load correctly on Edge.");
            test.pass("Product Page loaded successfully in Edge browser.");

        } catch (Exception e) {
            test.fail("Failed to load Product Page on Edge. Exception: " + e.getMessage());
            Assert.fail("Exception occurred while verifying Product Page load on Edge: " + e.getMessage());
        } finally {
            // Step 5: Close Edge browser
            if (driver != null) {
                driver.quit();
            }
            extent.flush();
        }
    }
}
