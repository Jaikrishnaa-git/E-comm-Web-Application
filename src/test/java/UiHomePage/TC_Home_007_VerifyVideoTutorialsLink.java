package UiHomePage;

import java.io.IOException;
import java.util.ArrayList;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_007_VerifyVideoTutorialsLink extends BaseTest {

    @Test
    public void verifyVideoTutorialsLink() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Video Tutorials Link on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        String parentWindow = driver.getWindowHandle();

        try {
            home.clickVideoTutorials();
            Thread.sleep(3000);

            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            windows.remove(parentWindow);
            driver.switchTo().window(windows.get(0));

            if (driver.getTitle().toLowerCase().contains("youtube")) {
                test.pass("Video Tutorials link opened YouTube successfully");
            } else {
                test.fail("Video Tutorials link did not open YouTube")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_007"));
            }

            driver.close();
            driver.switchTo().window(parentWindow);

        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_007"));
        }
    }
}
