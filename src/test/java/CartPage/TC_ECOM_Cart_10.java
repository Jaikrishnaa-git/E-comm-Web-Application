package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_10 extends BaseTest {

    @Test
    public void verifyLogoInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_10 - Verify Logo in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Logo
        cartPage.clickLogo();

        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Logo clicked successfully and navigated to Home Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_10"));
        } else {
            test.fail("Navigation failed after clicking Logo. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_10"));
            Assert.fail("Navigation failed after clicking Logo");
        }
    }
}
