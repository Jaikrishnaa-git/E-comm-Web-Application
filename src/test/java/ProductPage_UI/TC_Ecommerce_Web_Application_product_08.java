package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.util.List;

public class TC_Ecommerce_Web_Application_product_08 extends BaseTest {

    @Test
    public void verifyContactUsButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_08 - Verify Contact Us button in Product page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Locate 'Contact Us' button
            List<WebElement> contactUsBtns = driver.findElements(By.xpath("//a[contains(text(),'Contact us')]"));

            if (contactUsBtns.isEmpty()) {
                test.skip("Contact Us button not found on Product page. Test skipped.");
                Assert.fail("Contact Us button not available on Product page");
                return;
            }

            // Step 3: Click the button
            contactUsBtns.get(0).click();
            test.pass("Clicked on 'Contact Us' button");

            // Step 4: Verify navigation → should go to Contact Us page
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("/contact_us"),
                    "Did not navigate to Contact Us page. Current URL: " + currentUrl);
            test.pass("Successfully navigated to Contact Us page: " + currentUrl);

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
