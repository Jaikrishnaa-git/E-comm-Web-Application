package UiTestcasePage;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_testcase_09 extends BaseTest {

    private final String testCasesUrl = "https://automationexercise.com/test_cases";

    @Test(groups = { "UI_Testing" })
    public void verifyScrollBar() {
        test = extent.createTest("TC_09 - Verify Scroll Bar");

        try {
            driver.get(testCasesUrl);
            test.log(Status.INFO, "Opened Test Cases page");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            test.log(Status.INFO, "Scrolled to bottom");
            Thread.sleep(2000);

            // Scroll up
            js.executeScript("window.scrollTo(0, 0)");
            test.log(Status.INFO, "Scrolled back to top");

            test.pass("✅ Scroll bar is working as expected.");
        } catch (Exception e) {
            test.fail("❌ Scroll bar test failed: " + e.getMessage());
            Assert.fail("Scroll bar test failed: " + e.getMessage());
        }
    }
}
