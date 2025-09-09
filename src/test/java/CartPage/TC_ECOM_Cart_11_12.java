package CartPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.CartPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Cart_11_12 extends BaseTest {

	@Test
	public void verifySubscriptionTextboxInCartPage() throws IOException {
	    driver.get("https://automationexercise.com/view_cart");
	    test = extent.createTest("TC_ECOM_Cart_11_12 - Verify Subscription Textbox in Cart Page");

	    CartPage cartPage = new CartPage(driver);

	    // Step 1: Enter email in subscription textbox
	    String email = "testuser@example.com";
	    cartPage.enterSubscriptionEmail(email);

	    String enteredText = cartPage.getEnteredSubscriptionText();

	    if (enteredText.equals(email)) {
	        test.pass("Email entered successfully in subscription textbox")
	            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_11_12"));
	    } else {
	        test.fail("Failed to enter email in subscription textbox. Expected: " + email + " but got: " + enteredText)
	            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_11_12"));
	        Assert.fail("Failed to enter email in subscription textbox");
	    }
	}


    @Test
    public void verifySubscriptionArrowButtonInCartPage() throws IOException {
        driver.get("https://automationexercise.com/view_cart");
        test = extent.createTest("TC_ECOM_Cart_11_12 - Verify Subscription Arrow Button in Cart Page");

        CartPage cartPage = new CartPage(driver);

        // Step 1: Enter email before clicking arrow
        String email = "testuser@example.com";
        cartPage.enterSubscriptionEmail(email);

        // Step 2: Click arrow button
        cartPage.clickSubscriptionArrowButton();

        // Expected: Success message should be displayed
        String successMessage = cartPage.getSubscriptionSuccessMessage();
        String expectedMessage = "You have been successfully subscribed!";

        if (successMessage.contains(expectedMessage)) {
            test.pass("Arrow button clicked successfully and subscription message displayed: " + successMessage)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_11_12"));
        } else {
            test.fail("Subscription failed. Expected message: " + expectedMessage + " but got: " + successMessage)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Cart_11_12"));
            Assert.fail("Subscription failed after clicking arrow button");
        }
    }
}
