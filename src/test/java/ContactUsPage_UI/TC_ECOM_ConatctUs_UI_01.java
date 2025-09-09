package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ConatctUs_UI_01 extends BaseTest {

    @Test
    public void verifyHomeButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_Ecommerce_Web_Application_contactus_01 - Verify Home button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickHomeButton();

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Home button clicked successfully and navigated to Home Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_01"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_01"));
            Assert.fail("Navigation failed after clicking Home button in Contact Us page");
        }
    }
}
