package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_05 extends BaseTest {

    @Test
    public void verifyTestCasesButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_Ecommerce_Web_Application_contactus_05 - Verify Test Cases button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickTestCasesButton();

        String expectedUrl = "https://automationexercise.com/test_cases";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Test Cases button clicked successfully and navigated to Test Cases Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_05"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_05"));
            Assert.fail("Navigation failed after clicking Test Cases button in Contact Us page");
        }
    }
}
