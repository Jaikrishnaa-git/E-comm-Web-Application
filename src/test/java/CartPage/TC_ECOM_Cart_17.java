package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_17 extends BaseTest {

    @Test
    public void verifyRemoveFromCartButton() throws IOException, InterruptedException {
        driver.get("https://automationexercise.com/");
        test = extent.createTest("TC_ECOM_Cart_17 - Verify Remove from Cart (X button) in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Add Blue Top to cart
        cartPage.addBlueTopToCart();
        Thread.sleep(2000); // wait for modal popup
        cartPage.clickViewCartInModal();

        // Step 2: Verify Blue Top is present in cart
        if (cartPage.isBlueTopDisplayedInCart()) {
            test.pass("Blue Top successfully added to cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_17"));
        } else {
            test.fail("Blue Top was not added to cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_17"));
            Assert.fail("Blue Top not found in cart!");
        }

        // Step 3: Click Remove (X) button
        cartPage.removeFromCart();
        Thread.sleep(2000); // wait for removal to reflect

        // Step 4: Verify Blue Top is removed from cart
        if (!cartPage.isBlueTopDisplayedInCart()) {
            test.pass("Blue Top successfully removed from cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_17"));
        } else {
            test.fail("Blue Top was not removed from cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_17"));
            Assert.fail("Remove from cart failed!");
        }
    }
}
