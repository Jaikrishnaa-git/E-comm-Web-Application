package Business_Specific_needs;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.BusinessSpecificNeedsPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Busi_needs_05 extends BaseTest {

	@Test(groups = { "Business_Specific_needs" })
    public void verifyAllTestCasesAreDisplayed() throws IOException {
        // Step 1: Open the Application
        driver.get("https://www.automationexercise.com/");
        test = extent.createTest("TC_ECOM_Busi_needs_05 - To verify and validate all test cases are listed on the Test Cases page");

        // Step 2: Create Page Object
        BusinessSpecificNeedsPage businessPage = new BusinessSpecificNeedsPage(driver);

        // Step 3: Navigate to Test Cases page
        businessPage.clickOnTestCasesLink();

        // Step 4: Get all test case links
        List<WebElement> testCasesList = businessPage.getAllTestCases();

        // Step 5: Validation
        if (testCasesList != null && !testCasesList.isEmpty()) {
            test.pass("All test cases are displayed. Total test cases found: " + testCasesList.size())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_05"));
        } else {
            test.fail("No test cases were found on the Test Cases page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_05"));
            Assert.fail("Test cases list is empty on the Test Cases page.");
        }
    }
}
