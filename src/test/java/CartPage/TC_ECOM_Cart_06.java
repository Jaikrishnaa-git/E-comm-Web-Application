package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_06 extends BaseTest {

    @Test
    public void verifyApiTestingButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_06 - Verify API Testing Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Cart page link
        cartPage.clickCartLink();

        // Step 2: Click on API Testing button
        cartPage.clickApiTestingButton();

        // Step 3: Validate navigation to API Testing page
        String expectedUrl = "https://automationexercise.com/api_list";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("API Testing button clicked successfully and navigated to API List page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_06"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_06"));
            Assert.fail("Navigation failed after clicking API Testing button in cart page");
        }
    }
}
