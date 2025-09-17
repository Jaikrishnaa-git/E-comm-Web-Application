package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_24_25 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test(groups = { "UI_Testing" })
    public void verifyTestCase5RegisterUserWithExistingEmail() {
        test = extent.createTest("TC_ECOM_TestCase_5 - Verify Register User with Existing Email");

        try {
            // Step 1, 2 & 3: Open Test Cases page and click TC5
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 5: Register User with existing email");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 5: Register User with existing email");

            // Verify the link is opened
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 5 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 5 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 5 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase6ContactUsForm() {
        test = extent.createTest("TC_ECOM_TestCase_6 - Verify Contact Us Form");

        try {
            // Step 1, 2 & 3: Open Test Cases page and click TC6
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 6: Contact Us Form");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 6: Contact Us Form");

            // Verify the link is opened
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 6 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 6 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 6 failed: " + e.getMessage());
            throw e;
        }
    }
}
