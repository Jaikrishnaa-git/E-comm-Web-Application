package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_04 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifySignupLoginButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_04 - Verify Signup/Login button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickSignupLoginButton();

        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Signup/Login button clicked successfully and navigated to Login Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_04"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_04"));
            Assert.fail("Navigation failed after clicking Signup/Login button in Contact Us page");
        }
    }
}
