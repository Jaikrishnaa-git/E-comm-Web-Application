package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_14 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyTopButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_14 - Verify #top button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        // Step 1: Scroll down so that the #top button becomes visible
        contactUs.scrollDown(1000);

        // Step 2: Click on #top button and validate
        boolean isAtTop = contactUs.clickTopButtonAndValidate();

        if (isAtTop) {
            test.pass("#top button clicked successfully and page scrolled back to top")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_14"));
        } else {
            test.fail("#top button did not work as expected")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_14"));
            Assert.fail("#top button validation failed in Contact Us page");
        }
    }
}
