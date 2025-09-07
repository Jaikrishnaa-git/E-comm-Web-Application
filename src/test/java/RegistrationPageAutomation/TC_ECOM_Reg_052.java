package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_052 extends BaseTest {

    @Test
    public void verifyEmptyZipcodeField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_052 - Validate Zipcode with no input");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Navigate to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login");

        // Generate unique email
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Fill form but leave Zipcode blank
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "TestCompany", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "", "9876543210");
        test.info("Filled account form with empty Zipcode");

        // Step 4: Submit form
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_052");

        // Validate browser message
        String validationMsg = sp.getZipcodeValidationMessage();

        if (validationMsg != null && validationMsg.contains("Please fill")) {
            test.pass("PASS: Validation message displayed for empty Zipcode: " + validationMsg)
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("FAIL: No validation message for empty Zipcode field")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Zipcode field accepted empty input.");
        }
    }
}
