package CartPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_16 extends BaseTest {

    @Test
    public void verifyCartQuantityCountClickable() throws IOException, InterruptedException {
        driver.get("https://automationexercise.com/");
        test = extent.createTest("TC_ECOM_Cart_16 - Verify Cart Quantity Count Clickable");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Add Blue Top to cart
        cartPage.addBlueTopToCart();
        Thread.sleep(2000); // wait for modal popup

        // Step 2: Click 'View Cart' in modal
        cartPage.clickViewCartInModal();

        // Step 3: Check if cart quantity count is clickable
        WebElement cartCountElement = driver.findElement(cartPage.cartCount); // using locator from CartPage
        if (cartCountElement.isDisplayed() && cartCountElement.isEnabled()) {
            test.pass("Cart quantity count is clickable")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_16_CartCountClickable"));
        } else {
            test.fail("Cart quantity count is NOT clickable")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_16_CartCountNotClickable"));
            Assert.fail("Cart quantity count is not clickable");
        }
    }
}
