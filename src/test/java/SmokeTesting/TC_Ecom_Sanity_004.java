package SmokeTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.pages.CartPage;

public class TC_Ecom_Sanity_004 extends BaseTest {

    @Test
    public void verifyCartFunctionality() {
        test = extent.createTest("TC_Ecom_Sanity_004 - Verify Cart Functionality");

        try {
            // Step 1: Open URL & go to Products page
            ProductsPage products = new ProductsPage(driver);
            products.openProducts();
            test.info("Step 1: Opened URL and navigated to Products page");

            // Step 2: Add first product twice
            products.addFirstProductToCart();
            products.addFirstProductToCart();
            test.info("Step 2: Added first product twice to cart");

            // Step 3: Open cart and verify
            CartPage cart = new CartPage(driver);
            cart.openCart();
            String productName = cart.getFirstProductName();
            String quantity = cart.getFirstProductQuantity();

            Assert.assertEquals(quantity, "2", "❌ Cart quantity did not match expected value");
            test.pass("Step 3: ✅ Cart contains product '" + productName + "' with quantity = " + quantity);

            // Step 4: Remove product and check empty
            cart.removeFirstProduct();
            Thread.sleep(2000); // wait for UI refresh
            Assert.assertTrue(cart.isCartEmpty(), "❌ Cart not empty after removal");
            test.pass("Step 4: ✅ Product removed successfully, cart is empty");

        } catch (Exception e) {
            test.fail("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
