package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_10 extends BaseTest {

    @Test
    public void verifyLogoInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_10 - Verify Logo in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        // Check if logo is displayed
        boolean isLogoVisible = contactUs.isLogoDisplayed();

        if (isLogoVisible) {
            test.pass("Logo is displayed successfully on Contact Us page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_10"));
        } else {
            test.fail("Logo is not displayed on Contact Us page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_10"));
            Assert.fail("Logo validation failed in Contact Us page");
        }
    }
}
