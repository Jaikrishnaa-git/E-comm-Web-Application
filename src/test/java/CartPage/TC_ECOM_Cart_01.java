package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_01 extends BaseTest {

    @Test
    public void verifyHomeButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_01 - Verify Home Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Cart page link
        cartPage.clickCartLink();

        // Step 2: Click on Home button
        cartPage.clickHomeButton();

        // Step 3: Validate navigation to home page
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Home button clicked successfully and navigated to home page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_01"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_01"));
            Assert.fail("Navigation failed after clicking Home button in cart page");
        }
    }
}
