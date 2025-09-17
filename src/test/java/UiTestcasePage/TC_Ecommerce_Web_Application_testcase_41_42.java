package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_41_42 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test(groups = { "UI_Testing" })
    public void verifyTestCase23VerifyAddressDetailsInCheckoutPage() {
        test = extent.createTest("TC_ECOM_TestCase_23 - Verify Address Details in Checkout Page");

        try {
            // Step 1–3: Open Test Cases page and click Test Case 23
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 23: Verify address details in checkout page");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 23: Verify address details in checkout page");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 23 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 23 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 23 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase24DownloadInvoiceAfterPurchase() {
        test = extent.createTest("TC_ECOM_TestCase_24 - Verify Download Invoice After Purchase");

        try {
            // Step 1–3: Open Test Cases page and click Test Case 24
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 24: Download Invoice after purchase order");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 24: Download Invoice after purchase order");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 24 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 24 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 24 failed: " + e.getMessage());
            throw e;
        }
    }
}
