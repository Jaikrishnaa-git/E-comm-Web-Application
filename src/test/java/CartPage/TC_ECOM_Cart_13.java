package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_13 extends BaseTest {

    @Test
    public void verifyOrangeHomeButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_13 - Verify Orange Secondary Home Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Orange Secondary Home Button
        cartPage.clickOrangeHomeButton();

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Orange secondary home button clicked successfully and navigated to Home Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_13"));
        } else {
            test.fail("Navigation failed after clicking Orange secondary home button. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_13"));
            Assert.fail("Navigation failed after clicking Orange secondary home button");
        }
    }
}
