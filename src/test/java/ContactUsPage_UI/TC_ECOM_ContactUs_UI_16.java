package ContactUsPage_UI;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_16 extends BaseTest {

    @Test
    public void verifySubscriptionArrowButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_16 - Verify Subscription Arrow Button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        try {
            // Step 1: Scroll down to make subscription section visible
            contactUs.scrollPage(0, 800);

            // Step 2: Enter a sample email
            String email = "testuser@example.com";
            contactUs.enterSubscriptionEmail(email);

            // Step 3: Click on subscription arrow button
            contactUs.clickSubscriptionArrowButton();

            // Step 4: If no exception occurs, consider the button click successful
            test.pass("Subscription arrow button clicked successfully")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_16"));

        } catch (Exception e) {
            test.fail("Subscription arrow button could not be clicked")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_16"));
            Assert.fail("Subscription arrow button validation failed in Contact Us page: " + e.getMessage());
        }
    }
}
