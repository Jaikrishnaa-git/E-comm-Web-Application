package ContactUsPage_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_ContactUs_UI_02 extends BaseTest {

    @Test
    public void verifyProductButtonInContactUsPage() throws IOException {
        driver.get("https://automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_ContactUs_UI_02 - Verify Product button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.clickProductsButton();

        String expectedUrl = "https://automationexercise.com/products";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Product button clicked successfully and navigated to Products Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_02"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_UI_02"));
            Assert.fail("Navigation failed after clicking Product button in Contact Us page");
        }
    }
}
