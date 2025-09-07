package Business_Specific_needs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.BusinessSpecificNeedsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.Status;

public class TC_ECOM_Busi_needs_08 extends BaseTest {

    @Test
    public void verifySiteBehaviour() throws IOException {
        test = extent.createTest("TC_ECOM_Busi_needs_08 - Verify Site Behaviour");

        // Step 1: Open the Application
        driver.get("https://www.automationexercise.com/");
        test.log(Status.INFO, "Opened Automation Exercise homepage");

        BusinessSpecificNeedsPage page = new BusinessSpecificNeedsPage(driver);

        // Step 2: Validate website stability by checking page title or a key element
        String pageTitle = driver.getTitle();  // You can also check for logo visibility
        test.log(Status.INFO, "Page title: " + pageTitle);

        try {
            Assert.assertTrue(pageTitle.contains("Automation Exercise"), "Website is not stable or homepage not loaded.");
            test.pass("Website is stable and loaded successfully")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_08"));
        } catch (AssertionError e) {
            test.fail("Website is not stable or homepage failed to load")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_08"));
            throw e;
        }
    }
}
