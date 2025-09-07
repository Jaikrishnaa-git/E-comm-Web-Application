package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_051 extends BaseTest {

    @Test
    public void verifyValidZipcodeField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_051 - Validate Zipcode with valid input");

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

        // Step 3: Fill form with valid Zipcode
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "TestCompany", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "630002", "9876543210");
        test.info("Filled account form with valid Zipcode: 630002");

        // Step 4: Submit form
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_051");

        // Validate registration result
        if (sp.isAccountCreated()) {
            test.pass("PASS: User successfully registered with valid Zipcode")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("FAIL: User could not register with valid Zipcode")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration failed with valid Zipcode input.");
        }
    }
}
