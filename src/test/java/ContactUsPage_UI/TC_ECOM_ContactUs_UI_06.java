package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_06 extends BaseTest {

    @Test
    public void verifyApiTestingButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_06 - Verify API Testing button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickApiTestingButton();

        String expectedUrl = "https://automationexercise.com/api_list";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("API Testing button clicked successfully and navigated to API List Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_06"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_06"));
            Assert.fail("Navigation failed after clicking API Testing button in Contact Us page");
        }
    }
}
