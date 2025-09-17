package Business_Specific_needs;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.BusinessSpecificNeedsPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Busi_needs_04 extends BaseTest {

	@Test(groups = { "Business_Specific_needs" })
    public void verifyTestCasesPageNavigation() throws IOException {
        // Step 1: Open the Application
        driver.get("https://www.automationexercise.com/");
        test = extent.createTest("TC_ECOM_Busi_needs_04 - To verify and validate the Test Cases page can be navigated");

        // Step 2: Create Page Object
        BusinessSpecificNeedsPage businessPage = new BusinessSpecificNeedsPage(driver);

        // Step 3: Navigate to Test Cases page
        businessPage.clickOnTestCasesLink();

        // Step 4: Validation
        String headerText = businessPage.getTestCasesHeaderText();
        if (headerText.contains("TEST CASES")) {
            test.pass("Test Cases page loaded successfully without errors")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_04"));
        } else {
            test.fail("Test Cases page did not load correctly or header not found")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_04"));
            Assert.fail("Navigation to Test Cases page failed.");
        }
    }
}
