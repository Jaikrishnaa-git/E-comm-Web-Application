package UiTestcasePage;



import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_28_29 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase11VerifySubscriptionInCartPage() {
        test = extent.createTest("TC_ECOM_TestCase_11 - Verify Subscription in Cart Page");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 11
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 11: Verify Subscription in Cart page");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 11: Verify Subscription in Cart page");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 11 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 11 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 11 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase12AddProductsInCart() {
        test = extent.createTest("TC_ECOM_TestCase_12 - Verify Add Products in Cart");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 12
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 12: Add Products in Cart"); // ✅ Fixed text

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 12: Add Products in Cart"); // ✅ Fixed text

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 12 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 12 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 12 failed: " + e.getMessage());
            throw e;
        }
    }
}
