package TestCases;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ECOM_TestCase_1 extends BaseTest {

    @Test
    public void verifyTestCasesPageLoads() {
        test = extent.createTest("TC_ECOM_TestCase_1 - Verify Test Cases Page Loads");

        try {
            // Step 1: Open browser and navigate to URL
            HomePage home = new HomePage(driver);
            home.open();
            test.info("Step 1: Opened the browser and navigated to home page");

            // Verify home page is visible
            Assert.assertTrue(home.isHomePageVisible(), "❌ Home Page not visible.");
            test.pass("✅ Home Page loaded successfully");

            // Step 2: Click on Test Cases
            home.clickTestCases();
            test.info("Step 2: Clicked on 'Test Cases' link");

            // Step 3: Verify Test Cases page is loaded
            Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"),
                    "❌ Test Cases page did not load properly.");
            test.pass("✅ Test Cases page loaded successfully");

            // Final Result
            test.pass("🎉 TC_ECOM_TestCase_1 Passed: Test Cases page opens correctly.");

        } catch (Exception e) {
            test.fail("❌ Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
