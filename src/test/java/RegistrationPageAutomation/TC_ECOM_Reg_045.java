package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_045 extends BaseTest {

    @Test
    public void verifyNoStateField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_045 - Validate State field with no input");

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

        // Step 3: Fill form with empty State
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "20", "August", "1992", true, true,
                "MyCompany", "12, Gandhi Street", "Near Park",
                "India", "", "Chennai", "600100", "9876543210");
        test.info("Filled form with no State input");

        // Step 4: Submit Create Account
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_045");

        // Step 5: Verify
        if (sp.isAccountCreated()) {
            test.fail("❌ FAIL: User was able to register with empty State input")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Application allowed registration with no State field input.");
        } else {
            test.pass("✅ PASS: User was not able to register with empty State input (as expected)")
                .addScreenCaptureFromPath(shot);
        }
    }
}
