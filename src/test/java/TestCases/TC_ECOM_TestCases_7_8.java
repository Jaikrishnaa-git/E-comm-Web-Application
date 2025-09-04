package TestCases;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_ECOM_TestCases_7_8 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase7VerifyTestCasePage() {
        test = extent.createTest("TC_ECOM_TestCase_7 - Verify Test Case Page");

        try {
            // Step 1, 2 & 3: Open Test Cases page and click TC7
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 7: Verify Test Cases Page");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 7: Verify Test Cases Page");

            // Verify the link is opened
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 7 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 7 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 7 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase8VerifyAllProducts() {
        test = extent.createTest("TC_ECOM_TestCase_8 - Verify All Products");

        try {
            // Step 1, 2 & 3: Open Test Cases page and click TC8
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 8: Verify All Products");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 8: Verify All Products");

            // Verify the link is opened
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 8 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 8 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 8 failed: " + e.getMessage());
            throw e;
        }
    }
}
