package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_02 extends BaseTest {

    @Test
    public void verifyProductButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_02 - Verify Product Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Cart page link
        cartPage.clickCartLink();

        // Step 2: Click on Product button
        cartPage.clickProductButton();

        // Step 3: Validate navigation to Products page
        String expectedUrl = "https://automationexercise.com/products";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Product button clicked successfully and navigated to Products page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_02"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_02"));
            Assert.fail("Navigation failed after clicking Product button in cart page");
        }
    }
}
