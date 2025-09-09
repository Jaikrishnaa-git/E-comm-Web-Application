package ContactUsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Contact_us_1 extends BaseTest {

    @Test
    public void verifyAutomationExerciseButtonInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_1 - Verify Automation Exercise Button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickAutomationExerciseButton();

        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Automation Exercise button clicked successfully and navigated to home page")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_01"));;
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_01"));
            Assert.fail("Navigation failed after clicking Automation Exercise button");
        }
    }
}
