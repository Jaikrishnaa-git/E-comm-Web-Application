package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_006_VerifyAPITestingButton extends BaseTest {

    @Test
    public void verifyAPITestingButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify API Testing Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            home.clickApiTesting();
            Thread.sleep(2000);
            if (driver.getCurrentUrl().contains("api_list")) {
                test.pass("API Testing page opened successfully");
            } else {
                test.fail("API Testing page did not open")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_006"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_006"));
        }
    }
}
