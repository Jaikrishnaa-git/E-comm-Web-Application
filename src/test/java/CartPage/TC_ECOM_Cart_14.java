package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_14 extends BaseTest {

    @Test
    public void verifyProceedToCheckoutButtonInCartPage() throws IOException, InterruptedException {
        driver.get("https://automationexercise.com/");
        test = extent.createTest("TC_ECOM_Cart_14 - Verify Proceed To Checkout Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Add Blue Top to cart
        cartPage.addBlueTopToCart();
        Thread.sleep(2000); // wait for modal popup

        // Step 2: Click 'View Cart' in modal
        cartPage.clickViewCartInModal();

        // Step 3: Verify Blue Top is present in cart
        if (cartPage.isBlueTopDisplayedInCart()) {
            test.pass("Blue Top successfully added to cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_14"));
        } else {
            test.fail("Blue Top was not added to cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_14"));
            Assert.fail("Blue Top not found in cart!");
        }

        // Step 4: Verify 'Proceed To Checkout' button is clickable
        try {
            cartPage.clickProceedToCheckout();
            test.pass("Proceed To Checkout button is clickable")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_14"));
        } catch (Exception e) {
            test.fail("Proceed To Checkout button is not clickable: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_14"));
            Assert.fail("Proceed To Checkout button is not clickable.");
        }
    }
}
