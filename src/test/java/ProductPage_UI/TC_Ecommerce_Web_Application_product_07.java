package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.util.List;

public class TC_Ecommerce_Web_Application_product_07 extends BaseTest {

    @Test
    public void verifyVideoTutorialsButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_07 - Verify Video Tutorials button in Product page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Try to find 'Video Tutorials' button
            List<WebElement> videoBtns = driver.findElements(By.xpath("//a[contains(text(),'Video Tutorials')]"));

            if (videoBtns.isEmpty()) {
                test.skip("Video Tutorials button not found on Product page. Test skipped.");
                Assert.fail("Video Tutorials button not available on Product page");
                return;
            }

            // Step 3: Click button
            videoBtns.get(0).click();
            test.pass("Clicked on 'Video Tutorials' button");

            // Step 4: Verify navigation → should go to YouTube channel
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("youtube.com/c/AutomationExercise"),
                    "Did not navigate to Video Tutorials (YouTube) page. Current URL: " + currentUrl);
            test.pass("Successfully navigated to YouTube Video Tutorials page: " + currentUrl);

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
