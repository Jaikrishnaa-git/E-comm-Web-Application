package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_30_31 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase13VerifyProductQuantity() {
        test = extent.createTest("TC_ECOM_TestCase_13 - Verify Product Quantity");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 13
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 13: Verify Product quantity in Cart");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 13: Verify Product quantity in Cart");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 13 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 13 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 13 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase14PlaceOrderRegisterWhileCheckout() {
        test = extent.createTest("TC_ECOM_TestCase_14 - Place Order: Register while Checkout");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 14
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 14: Place Order: Register while Checkout");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 14: Place Order: Register while Checkout");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 14 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 14 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 14 failed: " + e.getMessage());
            throw e;
        }
    }
}
