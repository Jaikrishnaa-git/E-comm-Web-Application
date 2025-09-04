package TestCases;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_ECOM_TestCase_54 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyFeedbackEmailClick() {
        test = extent.createTest("TC_ECOM_TestCase_54 - Verify Feedback Email Click");

        try {
            // Step 1-2: Open Test Cases page
            testCasesPage.openTestCasesPage();
            test.info("✅ Navigated to Test Cases page.");

            // Step 3: Click on feedback email
            testCasesPage.clickFeedbackEmail();
            test.info("📩 Clicked on Feedback Email: feedback@automationexercise.com");

            // Verify redirection or presence (optional)
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Feedback email click did not work properly. URL: " + actualUrl);

            test.pass("✅ Feedback email clicked successfully. Current URL: " + actualUrl);

        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 54 failed: " + e.getMessage());
            throw e;
        }
    }
}
