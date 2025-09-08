package TestCases;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_ECOM_TestCases_9_10 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase9SearchProduct() {
        test = extent.createTest("TC_ECOM_TestCase_9 - Verify Search Product");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 9
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 9: Search Product");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 9: Search Product");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 9 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 9 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 9 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase10VerifySubscription() {
        test = extent.createTest("TC_ECOM_TestCase_10 - Verify Subscription");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 10
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 10: Verify Subscription");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 10: Verify Subscription");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 10 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 10 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 10 failed: " + e.getMessage());
            throw e;
        }
    }
}
