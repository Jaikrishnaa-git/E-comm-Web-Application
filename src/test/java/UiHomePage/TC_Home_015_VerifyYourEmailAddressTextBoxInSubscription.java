package UiHomePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_015_VerifyYourEmailAddressTextBoxInSubscription extends BaseTest {

    @Test
    public void verifyEmailAddressTextBox() throws IOException {
        ExtentTest test = extent.createTest("Verify 'Your Email Address' textbox in Subscription section");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            boolean isVisible = home.isSubScriptionVisible();
            if (isVisible) {
                test.pass("'Your Email Address' textbox is visible");
            } else {
                test.fail("'Your Email Address' textbox is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_015"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_015"));
        }
    }
}
