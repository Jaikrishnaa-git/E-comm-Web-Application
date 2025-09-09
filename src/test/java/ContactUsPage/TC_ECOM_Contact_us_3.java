package ContactUsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Contact_us_3 extends BaseTest {

    @Test
    public void verifyFeedbackVisibilityInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_3 - Verify Feedback visibility in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        boolean feedbackVisible = contactUs.isFeedbackDisplayed();

        if (feedbackVisible) {
            test.pass("Feedback is visible on the Contact Us page")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_03"));;
        } else {
            test.fail("Feedback is NOT visible on the Contact Us page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_03"));
            Assert.fail("Feedback is not displayed on Contact Us page");
        }
        
    }
}
