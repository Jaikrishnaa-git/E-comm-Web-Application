package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_008_VerifyContactUsButton extends BaseTest {

    @Test
    public void verifyContactUsButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Contact Us Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            home.clickContactUs();
            Thread.sleep(2000);
            if (driver.getCurrentUrl().contains("contact_us")) {
                test.pass("Contact Us page opened successfully");
            } else {
                test.fail("Contact Us page did not open")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_008"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_008"));
        }
    }
}
