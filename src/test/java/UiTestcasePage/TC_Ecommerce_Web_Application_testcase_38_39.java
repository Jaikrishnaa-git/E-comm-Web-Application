package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_38_39 extends BaseTest {

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPage() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void verifyTestCase21AddReviewOnProduct() {
        test = extent.createTest("TC_ECOM_TestCase_21 - Verify Add Review on Product");

        try {
            // Step 1–3: Open Test Cases page and click Test Case 21
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 21: Add review on product");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 21: Add review on product");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 21 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 21 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 21 failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void verifyTestCase22AddToCartFromRecommendedItem() {
        test = extent.createTest("TC_ECOM_TestCase_22 - Verify Add to Cart from Recommended Item");

        try {
            // Step 1–3: Open Test Cases page and click Test Case 22
            testCasesPage.openTestCasesPage();
            testCasesPage.clickTestCase("Test Case 22: Add to cart from Recommended items");

            // Step 4: Click inside link
            testCasesPage.clickInsideLink("Test Case 22: Add to cart from Recommended items");

            // Verify redirection
            String actualUrl = driver.getCurrentUrl();
            Assert.assertTrue(actualUrl.contains("automationexercise.com"),
                    "❌ Inside link of Test Case 22 did not open correctly. Actual URL: " + actualUrl);

            test.pass("✅ Test Case 22 executed successfully. URL: " + actualUrl);
        } catch (AssertionError | Exception e) {
            test.fail("❌ Test Case 22 failed: " + e.getMessage());
            throw e;
        }
    }
}
