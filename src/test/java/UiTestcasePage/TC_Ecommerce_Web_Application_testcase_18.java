package UiTestcasePage;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.TestCasesPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_testcase_18 extends BaseTest {

    /** ✅ TC18: Enter email and click subscription arrow button */
	@Test(groups = { "UI_Testing" })
    public void verifySubscriptionWithEmail() {
        test = extent.createTest("TC18 - Verify subscription textbox and arrow button on Test Cases page");

        try {
            TestCasesPage testCasesPage = new TestCasesPage(driver);

            // Step 1: Open Test Cases Page directly
            testCasesPage.openTestCasesPage();
            test.log(Status.INFO, "Opened Test Cases page.");

            Assert.assertTrue(testCasesPage.isPageVisible(), "❌ Test Cases page not visible!");
            test.log(Status.PASS, "✅ Test Cases page is visible.");

            // Step 2: Enter email in subscription textbox
            By subscriptionTextbox = By.id("susbscribe_email");
            driver.findElement(subscriptionTextbox).clear();
            driver.findElement(subscriptionTextbox).sendKeys("testuser@example.com");
            test.log(Status.INFO, "Entered email in subscription textbox.");

            // Step 3: Click subscription arrow button
            By subscriptionArrowBtn = By.id("subscribe");
            driver.findElement(subscriptionArrowBtn).click();
            test.log(Status.INFO, "Clicked on subscription arrow button.");

            // Step 4: Wait for success message
            By successMsg = By.xpath("//div[contains(@class,'alert-success')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String successText = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();

            // Step 5: Verify success message
            Assert.assertTrue(successText.contains("You have been successfully subscribed!"),
                    "❌ Success message not displayed!");
            test.log(Status.PASS, "✅ Success message displayed: " + successText);

        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Exception occurred in TC18: " + e.getMessage());
            Assert.fail("Test failed due to exception in TC18: " + e.getMessage());
        }
    }
}
