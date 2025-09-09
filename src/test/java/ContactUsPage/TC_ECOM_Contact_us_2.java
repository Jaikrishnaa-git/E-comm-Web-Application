package ContactUsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Contact_us_2 extends BaseTest {

    @Test
    public void verifyNoteVisibilityInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_2 - Verify Note visibility in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        boolean noteVisible = contactUs.isNoteDisplayed();

        if (noteVisible) {
            test.pass("Note is visible on the Contact Us page")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_02"));;
        } else {
            test.fail("Note is NOT visible on the Contact Us page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_02"));
            Assert.fail("Note is not displayed on Contact Us page");
        }
    }
}
