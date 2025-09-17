package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_20 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyValidMessageInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_12 - Verify Valid Input in Your Message Text box in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        String testMessage = "This is a valid automation test message.";
        contactUs.enterMessage(testMessage);


        if (testMessage.equals(testMessage)) {
            test.pass("User was able to type valid input in Your Message Here text box")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_ContactUs_UI_20"));;
        } else {
            test.fail("Message text box did not capture valid input")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_ContactUs_UI_20"));
            Assert.fail("Your Message text box failed to capture input");
        }
    }
}
