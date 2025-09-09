package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_07 extends BaseTest {

    @Test
    public void verifyVideoTutorialsButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_07 - Verify Video Tutorials Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Click on Cart page link
        cartPage.clickCartLink();

        // Step 2: Click on Video Tutorials button
        cartPage.clickVideoTutorialsButton();

        // Step 3: Validate navigation to Video Tutorials page
        String expectedUrl = "https://www.youtube.com/c/AutomationExercise";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            test.pass("Video Tutorials button clicked successfully and navigated to YouTube channel")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_07"));
        } else {
            test.fail("Navigation failed. Expected: " + expectedUrl + " but got: " + actualUrl)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_07"));
            Assert.fail("Navigation failed after clicking Video Tutorials button in cart page");
        }
    }
}
