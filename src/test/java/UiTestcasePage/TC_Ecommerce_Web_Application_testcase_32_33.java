package UiTestcasePage;



import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_32_33 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase15PlaceOrderRegisterBeforeCheckout() {
        test = extent.createTest("TC_ECOM_TestCase_15 - Place Order: Register before Checkout");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 15
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 15: Place Order: Register before Checkout");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 15: Place Order: Register before Checkout");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 15 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 15 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 15 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase16PlaceOrderLoginBeforeCheckout() {
        test = extent.createTest("TC_ECOM_TestCase_16 - Place Order: Login before Checkout");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 16
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 16: Place Order: Login before Checkout");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 16: Place Order: Login before Checkout");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 16 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 16 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 16 failed: " + e.getMessage());
            throw e;
        }
    }
}
