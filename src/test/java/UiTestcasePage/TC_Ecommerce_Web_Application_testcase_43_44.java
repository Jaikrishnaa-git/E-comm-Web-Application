package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_43_44 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase25ScrollUpWithArrowButton() {
        test = extent.createTest("TC_ECOM_TestCase_25 - Verify Scroll Up using Arrow button and Scroll Down functionality");

        try {
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality");
            testCasesPage.clickInsideLink("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality");

            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 25 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 25 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 25 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase26ScrollUpWithoutArrowButton() {
        test = extent.createTest("TC_ECOM_TestCase_26 - Verify Scroll Up without Arrow button and Scroll Down functionality");

        try {
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality");
            testCasesPage.clickInsideLink("Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality");

            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 26 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 26 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 26 failed: " + e.getMessage());
            throw e;
        }
    }
}
