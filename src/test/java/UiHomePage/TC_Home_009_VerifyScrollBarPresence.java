package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_Home_009_VerifyScrollBarPresence extends BaseTest {

    @Test
    public void verifyScrollBarPresence() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Scroll Bar Presence on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight");
            Long clientHeight = (Long) js.executeScript("return window.innerHeight");

            if (scrollHeight > clientHeight) {
                test.pass("Scroll bar is present on the home page");
            } else {
                test.fail("Scroll bar is not present on the home page")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_009"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_009"));
        }
    }
}
