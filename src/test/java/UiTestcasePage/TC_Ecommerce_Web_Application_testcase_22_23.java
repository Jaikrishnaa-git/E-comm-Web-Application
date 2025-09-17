package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_22_23 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test(groups = { "UI_Testing" })
    public void verifyTestCase3LoginUserIncorrectFlow() {
        test = extent.createTest("TC_ECOM_TestCase_3 - Verify Login User with Incorrect Email & Password");

        try {
            // Step 1, 2 & 3: Open Test Cases page and click TC3
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 3: Login User with incorrect email and password");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 3: Login User with incorrect email and password");

            // Verify the link is opened
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 3 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 3 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 3 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase4LogoutUserFlow() {
        test = extent.createTest("TC_ECOM_TestCase_4 - Verify Logout User Flow");

        try {
            // Step 1, 2 & 3: Open Test Cases page and click TC4
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 4: Logout User");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 4: Logout User");

            // Verify the link is opened
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 4 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 4 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 4 failed: " + e.getMessage());
            throw e;
        }
    }
}
