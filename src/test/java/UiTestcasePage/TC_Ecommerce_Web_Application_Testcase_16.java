package UiTestcasePage;


import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_Testcase_16 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyTopButtonInTestcasePage() {
        test = extent.createTest("TC16 - Verify and validate the #top button in the Test Cases page");

        try {
            // Initialize Page Object
            TestCasesPage testCasesPage = new TestCasesPage(driver);

            // Step 1: Open Test Cases Page directly
            testCasesPage.openTestCasesPage();
            test.log(Status.INFO, "Opened Test Cases page in Chrome.");

            Assert.assertTrue(testCasesPage.isPageVisible(), "❌ Test Cases page not visible!");
            test.log(Status.PASS, "✅ Test Cases page is visible.");

            // Step 2: Scroll down (so that #top button appears)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            test.log(Status.INFO, "Scrolled down to the bottom of the page.");

            // Step 3: Click on #top button
            driver.findElement(By.id("scrollUp")).click();
            test.log(Status.INFO, "Clicked on #top button.");

            // Step 4: Verify we are back at the top (Test Cases title is visible)
            Assert.assertTrue(testCasesPage.isPageVisible(), "❌ Did not return to top of the page!");
            test.log(Status.PASS, "✅ Successfully scrolled back to top using #top button.");

        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Exception occurred: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
