package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_004_VerifySignupLoginButton extends BaseTest {

    @Test
    public void verifySignupLoginButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Signup/Login Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            home.clickSignupLogin();
            Thread.sleep(2000);
            if (driver.getTitle().toLowerCase().contains("login")) {
                test.pass("Signup/Login page opened successfully");
            } else {
                test.fail("Signup/Login page did not open")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_004"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_004"));
        }
    }
}
