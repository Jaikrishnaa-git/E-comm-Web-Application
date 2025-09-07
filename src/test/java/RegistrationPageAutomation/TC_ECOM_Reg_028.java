package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_028 extends BaseTest {

    @Test
    public void verifyOffersCheckboxInSignupPage() throws IOException {
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_028 - Verify Offers Checkbox in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // ✅ New Signup Flow
        signup.newUserName("TestUser");
        signup.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Validate Offers checkbox is displayed
        if (signup.isOffersCheckboxDisplayed()) {
            test.pass("Offers checkbox is displayed on signup page");
        } else {
            test.fail("Offers checkbox is NOT displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_28"));
            Assert.fail("Offers checkbox not displayed");
        }

        // Step 4: Click Offers checkbox
        signup.clickOffersCheckbox();

        if (signup.isOffersCheckboxSelected()) {
            test.pass("Offers checkbox selected successfully")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_28"));
        } else {
            test.fail("Offers checkbox could not be selected")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_28"));
            Assert.fail("Offers checkbox not selected");
        }
    }
}
