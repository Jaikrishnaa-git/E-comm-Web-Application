package SmokeTesting;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Ecom_Sanity_006 extends BaseTest {

    @Test
    public void verifyAPIPage() throws InterruptedException, IOException {
        // Create Extent Test
        ExtentTest test = extent.createTest("TC_Ecom_Sanity_006 - Verify API page returns valid response");

        // Step 1: Open URL
        driver.get("https://www.automationexercise.com/");
        HomePage home = new HomePage(driver);
        test.info("Opened URL: https://www.automationexercise.com/");

        // Step 2: Click on API Testing
        try {
            home.clickApiTesting();
            test.info("Clicked on API Testing link");
            Thread.sleep(3000);

            // Step 3: Verify API Testing page
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.equals("https://www.automationexercise.com/")) {
                test.pass("Navigated to API Testing page successfully");
            } else {
                test.fail("Navigation to API Testing page failed")
                    .addScreenCaptureFromPath(
                        ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Sanity_006"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(
                    ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Sanity_006"));
        }
    }
}
