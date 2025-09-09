package UiHomePage;
import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_001_VerifyHomeButton extends BaseTest {

    @Test
    public void verifyHomeButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Home Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            if (home.isHomePageVisible()) {
                test.pass("Home page banner is visible");
            } else {
                test.fail("Home page banner not visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_001"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_001"));
        }
    }
}
