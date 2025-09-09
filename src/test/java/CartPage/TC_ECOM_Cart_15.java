package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_15 extends BaseTest {

    @Test
    public void verifyProductVisibleInCartPage() throws IOException, InterruptedException {
        driver.get("https://automationexercise.com/");
        test = extent.createTest("TC_ECOM_Cart_15 - Verify Product Visibility in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Add Blue Top to cart
        cartPage.addBlueTopToCart();
        Thread.sleep(2000); // wait for modal popup

        // Step 2: Click 'View Cart' in modal
        cartPage.clickViewCartInModal();

        // Step 3: Verify product (Blue Top) is present in cart
        if (cartPage.isBlueTopDisplayedInCart()) {
            test.pass("Blue Top is visible in the cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_15"));
        } else {
            test.fail("Blue Top is not visible in the cart")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_15"));
            Assert.fail("Blue Top not found in cart!");
        }
    }
}
