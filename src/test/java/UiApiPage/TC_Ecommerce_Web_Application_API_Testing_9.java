package UiApiPage;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Ecommerce_Web_Application_API_Testing_9 extends BaseTest {

    private final String apiPageUrl = "https://automationexercise.com/api_list";

    @Test(groups = { "UI_Testing" })
    public void verifyScrollBar() {
        test = extent.createTest("TC_API_09 - Verify Scroll Bar on API Page");

        try {
            driver.get(apiPageUrl);
            test.log(Status.INFO, "Opened API Page");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            test.log(Status.INFO, "Scrolled to bottom of API Page");
            Thread.sleep(2000);

            // Scroll up
            js.executeScript("window.scrollTo(0, 0)");
            test.log(Status.INFO, "Scrolled back to top of API Page");

            test.pass("✅ Scroll bar is working as expected on API Page.");
        } catch (Exception e) {
            test.fail("❌ Scroll bar test failed on API Page: " + e.getMessage());
            Assert.fail("Scroll bar test failed on API Page: " + e.getMessage());
        }
    }
}
