package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_08 extends BaseTest {

    @Test
    public void verifyContactUsButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_08 - Verify Contact Us Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Cart page link
        cartPage.clickCartLink();

        // Step 2: Click on Contact Us button
        cartPage.clickContactUsButton();

        // Step 3: Validate navigation to Contact Us page
        String expectedUrl = "https://automationexercise.com/contact_us";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Contact Us button clicked successfully and navigated to Contact Us page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_08"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_08"));
            Assert.fail("Navigation failed after clicking Contact Us button in cart page");
        }
    }
}
