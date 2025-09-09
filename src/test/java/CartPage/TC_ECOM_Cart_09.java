package CartPage;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_09 extends BaseTest {

    @Test
    public void verifyScrollBarInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_09 - Verify Scroll Bar in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Navigate to cart page
        cartPage.clickCartLink();

        // Step 2: Scroll to bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Step 3: Validate scroll by checking if reached bottom
        Long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        Long currentScroll = (Long) js.executeScript("return window.scrollY + window.innerHeight;");

        if (currentScroll.equals(scrollHeight)) {
            test.pass("Scroll bar is working. Successfully scrolled to the bottom of the cart page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_09"));
        } else {
            test.fail("Scroll bar is not working as expected")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_09"));
            Assert.fail("Scroll bar validation failed in cart page");
        }
    }
}
