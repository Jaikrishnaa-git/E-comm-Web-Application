package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_053 extends BaseTest {

    @Test
    public void verifyInvalidZipcodeField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_053 - Validate Zipcode with invalid input");

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

        // Step 3: Fill form with invalid Zipcode
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "TestCompany", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "ijkop", "9876543210");
        test.info("Filled account form with invalid Zipcode: ijkop");

        // Step 4: Submit form
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_053");

        // Analyze result
        if (sp.isAccountCreated()) {
            test.fail("FAIL: User was able to register with invalid Zipcode: ijkop")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration succeeded with invalid Zipcode input.");
        } else {
            test.pass("PASS: Registration blocked for invalid Zipcode")
                .addScreenCaptureFromPath(shot);
        }
    }
}
