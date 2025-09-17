package Subscription;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_subHome_004 extends BaseTest {

    @Test
    public void verifySubscriptionField() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Verify Subscription field visibility on Home Page");

        HomePage home = new HomePage(driver);

        if (home.isSubScriptionVisible()) {
            test.pass("Subscription field on home page is visible");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_subHome_004");
            test.fail("Subscription field is not visible on home page")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Subscription field not visible");
        }

        softAssert.assertAll();
    }
}
