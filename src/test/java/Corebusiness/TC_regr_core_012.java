package Corebusiness;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_regr_core_012 extends BaseTest {

    @Test
    public void verifyCartItemsCanBeUpdatedOrRemoved() throws IOException {
        test = extent.createTest("TC_regr_core_012 - Verify cart items can be updated or removed");

        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        try {
            
            products.openProducts();
            test.info("Opened Products Page");

            products.addFirstProductToCart();
            test.info("Added product to cart");

          
            cart.openCart();
            test.info("Opened Cart Page");

            
            cart.removeFirstProduct();

            
            Assert.assertTrue(cart.isCartEmpty(), "Cart should be empty after removing product");
            test.pass("Cart updated successfully - item removed and cart is empty");

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_012_Fail");
            test.fail("Test failed due to exception: " + e.getMessage())
                .addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}