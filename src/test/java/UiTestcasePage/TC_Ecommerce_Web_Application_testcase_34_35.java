package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_34_35 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test(groups = { "UI_Testing" })
    public void verifyTestCase17RemoveProductFromCart() {
        test = extent.createTest("TC_ECOM_TestCase_17 - Remove Product from Cart");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 17
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 17: Remove Products From Cart");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 17: Remove Products From Cart");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 17 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 17 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 17 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase18ViewCategoryProducts() {
        test = extent.createTest("TC_ECOM_TestCase_18 - View Category Products");

        try {
            // Step 1-3: Open Test Cases page and click Test Case 18
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 18: View Category Products");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 18: View Category Products");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 18 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 18 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 18 failed: " + e.getMessage());
            throw e;
        }
    }
}
