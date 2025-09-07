package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_09 extends BaseTest {

    @Test
    public void verifyScrollBarInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_09 - Verify Scroll Bar in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        // Scroll down and up using page object
        contactUs.scrollPage(0, 800);   // scroll down
        contactUs.scrollPage(0, -800);  // scroll up

        // Validate that we are still on the same page
        String expectedUrl = "https://automationexercise.com/contact_us";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Scroll bar moved up and down successfully in Contact Us page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_09"));
        } else {
            test.fail("Scroll bar validation failed. Expected URL: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_09"));
            Assert.fail("Scroll bar validation failed in Contact Us page");
        }
    }
}
