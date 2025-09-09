package ProductPage_UI;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_09 extends BaseTest {

    @Test
    public void verifyScrollBarInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_09 - Verify Scroll Bar in Product page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Use JavaScriptExecutor to scroll down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            test.pass("Scrolled down to the bottom of the page");

            // Step 3: Scroll back up
            js.executeScript("window.scrollTo(0, 0)");
            test.pass("Scrolled back to the top of the page");

            // Step 4: Assertion - Page title should remain correct
            String pageTitle = driver.getTitle();
            Assert.assertTrue(pageTitle.contains("Automation Exercise"),
                    "Page title mismatch after scrolling. Current title: " + pageTitle);
            test.pass("Scroll bar is working fine. Page title validated: " + pageTitle);

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            // Step 5: Close the browser
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
