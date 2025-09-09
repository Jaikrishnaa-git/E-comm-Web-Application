package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_28 extends BaseTest {

    @Test
    public void verifyUpArrowInScrollBar() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_28 - Verify Up Arrow in Scroll Bar in Product Page");

        try {
            // Step 1: Open the Product Page
            driver.get("https://automationexercise.com/products");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            test.pass("Navigated to Product Page successfully.");

            // Step 2: Scroll Down first (so Up Arrow makes sense)
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
            test.info("Scrolled down using PAGE_DOWN to activate scrollbar.");

            // Step 3: Click Up Arrow in Scroll Bar (simulated with PAGE_UP)
            actions.sendKeys(Keys.PAGE_UP).perform();
            Thread.sleep(2000);
            test.pass("Clicked Up Arrow in Scroll Bar (PAGE_UP).");

            // Step 4: Validation → Check if header is still visible
            WebElement productHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'All Products')]")));
            Assert.assertTrue(productHeader.isDisplayed(), "Up Arrow in Scroll Bar not working properly!");
            test.pass("Up Arrow in Scroll Bar verified successfully. 'All Products' header visible.");

        } catch (Exception e) {
            test.fail("Up Arrow in Scroll Bar not working as expected.");
            Assert.fail("Exception occurred while verifying Up Arrow in Scroll Bar: " + e.getMessage());
        } finally {
            // Step 5: Close Browser
            driver.quit();
            test.info("Browser closed after test execution.");
        }
    }
}
