package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Home_002_VerifyProductButton extends BaseTest {

    @Test
    public void verifyProductButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Products Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            home.clickProducts();
            Thread.sleep(2000);
            if (driver.getCurrentUrl().contains("/products")) {
                test.pass("Products page opened successfully");
            } else {
                test.fail("Products page did not open")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_002"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_002"));
        }
    }
}
