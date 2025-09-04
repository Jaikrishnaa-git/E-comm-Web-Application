
package TestCases;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_ECOM_TestCases_1_2 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase1RegisterUserFlow() {
        test = extent.createTest("TC_ECOM_TestCase_1 - Verify Register User Flow");

        try {
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 1: Register User");
            testCasesPage.clickInsideLink("Test Case 1: Register User");

            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 1 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 1 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 1 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase2LoginUserFlow() {
        test = extent.createTest("TC_ECOM_TestCase_2 - Verify Login User Flow");

        try {
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 2: Login User with correct email and password");
            testCasesPage.clickInsideLink("Test Case 2: Login User with correct email and password");

            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 2 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 2 executed successfully.");
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 2 failed: " + e.getMessage());
            throw e;
        }
    }
    
}
