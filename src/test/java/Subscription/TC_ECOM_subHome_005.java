package Subscription;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_subHome_005 extends BaseTest {

    @Test
    public void verifySubscriptionFieldVisibility() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Verify Subscription field visibility on Home Page");

        HomePage home = new HomePage(driver);

        if (home.isSubmitVisble()) {
            test.pass("Subscription field is visible on home page");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_subHome_005");
            test.fail("Subscription field is not visible on home page")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Subscription field not visible");
        }

        softAssert.assertAll();
    }
}
