package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;

public class TC_Home_003_VerifyCartButton extends BaseTest {

    @Test
    public void verifyCartButton() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Cart Button on Homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            home.clickCart();
            Thread.sleep(2000);
            if (driver.getCurrentUrl().contains("view_cart")) {
                test.pass("Cart page opened successfully");
            } else {
                test.fail("Cart page did not open")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_003"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_003"));
        }
    }
}
