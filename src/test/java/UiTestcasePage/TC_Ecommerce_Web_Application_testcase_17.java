package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_17 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifySubscriptionTextbox() {
        test = extent.createTest("TC17 - Verify and validate the subscription textbox in Test Cases page");

        try {
            // Initialize Page Object
            TestCasesPage testCasesPage = new TestCasesPage(driver);

            // Step 1: Open Test Cases Page directly
            testCasesPage.openTestCasesPage();
            test.log(Status.INFO, "Opened Test Cases page.");	

            Assert.assertTrue(testCasesPage.isPageVisible(), "❌ Test Cases page not visible!");
            test.log(Status.PASS, "✅ Test Cases page is visible.");

            // Step 2: Locate Subscription textbox
            By subscriptionTextbox = By.id("susbscribe_email");

            driver.findElement(subscriptionTextbox).sendKeys("testuser@example.com");
            test.log(Status.INFO, "Entered email in subscription textbox.");

            // Step 3: Verify the text was entered
            String enteredText = driver.findElement(subscriptionTextbox).getAttribute("value");
            Assert.assertEquals(enteredText, "testuser@example.com", "❌ Subscription textbox did not accept input!");
            test.log(Status.PASS, "✅ Subscription textbox accepted input correctly.");

        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Exception occurred: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
