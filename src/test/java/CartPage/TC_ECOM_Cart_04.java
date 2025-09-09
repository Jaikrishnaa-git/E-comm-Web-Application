package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_04 extends BaseTest {

    @Test
    public void verifySignupLoginButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_04 - Verify Signup/Login Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Cart page link
        cartPage.clickCartLink();

        // Step 2: Click on Signup/Login button
        cartPage.clickSignupLoginButton();

        // Step 3: Validate navigation to Signup/Login page
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Signup/Login button clicked successfully and navigated to Signup/Login page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_04"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_04"));
            Assert.fail("Navigation failed after clicking Signup/Login button in cart page");
        }
    }
}
