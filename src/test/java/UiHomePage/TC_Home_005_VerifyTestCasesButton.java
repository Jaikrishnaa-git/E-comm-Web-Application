package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_005_VerifyTestCasesButton extends BaseTest {

    @Test
    public void verifyTestCasesButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Test Cases Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            home.clickTestCases();
            Thread.sleep(2000);
            if (driver.getCurrentUrl().contains("test_cases")) {
                test.pass("Test Cases page opened successfully");
            } else {
                test.fail("Test Cases page did not open")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_005"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_005"));
        }
    }
}
