package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_07 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyVideoTutorialsButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_07 - Verify Video Tutorials button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickVideoTutorialsButton();

        String expectedUrl = "https://www.youtube.com/c/AutomationExercise";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Video Tutorials button clicked successfully and navigated to YouTube Channel")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_07"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_07"));
            Assert.fail("Navigation failed after clicking Video Tutorials button in Contact Us page");
        }
    }
}
