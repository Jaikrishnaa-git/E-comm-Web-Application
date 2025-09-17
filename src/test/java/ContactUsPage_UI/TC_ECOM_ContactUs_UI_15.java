package ContactUsPage_UI;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_15 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifySubscriptionTextBoxInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_15 - Verify Subscription Text Box in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        // Step 1: Scroll down to make subscription textbox visible
        contactUs.scrollPage(0, 800);

        // Step 2: Enter email in subscription textbox
        String email = "testuser@example.com";
        contactUs.enterSubscriptionEmail(email);

        // Step 3: Validate entered text
        String enteredText = contactUs.getSubscriptionEmailText();
        if (enteredText.equals(email)) {
            test.pass("Subscription textbox accepted input successfully")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_15"));
        } else {
            test.fail("Subscription textbox did not accept input correctly")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_15"));
            Assert.fail("Subscription textbox validation failed in Contact Us page");
        }
    }
}
