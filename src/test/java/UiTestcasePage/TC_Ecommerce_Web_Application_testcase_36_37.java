package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_36_37 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase19ViewAndCartBrandProducts() {
        test = extent.createTest("TC_ECOM_TestCase_19 - Verify View and Cart Brand Products");

        try {
            // Step 1–3: Open Test Cases page and click Test Case 19
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 19: View & Cart Brand Products");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 19: View & Cart Brand Products");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 19 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 19 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 19 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase20SearchProductAndVerifyCartLogin() {
        test = extent.createTest("TC_ECOM_TestCase_20 - Verify Search Product and Cart Login");

        try {
            // Step 1–3: Open Test Cases page and click Test Case 20
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 20: Search Products and Verify Cart After Login");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 20: Search Products and Verify Cart After Login");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 20 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 20 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 20 failed: " + e.getMessage());
            throw e;
        }
    }
}
