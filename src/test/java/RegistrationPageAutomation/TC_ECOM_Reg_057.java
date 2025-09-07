package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_057 extends BaseTest {

    @Test
    public void verifyCreateAccountButtonWithValidDetails() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_057 - Validate Create Account button with valid details");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Navigate to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login");

        // Generate a unique email to avoid conflicts
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Fill form with valid data
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "TestCompany", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");
        test.info("Filled account form with valid details");

        // Step 4: Click Create Account
        sp.submitCreateAccount();
        test.info("Clicked Create Account button");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_057");

        // Step 5: Verify registration success
        if (sp.isAccountCreated()) {
            test.pass("PASS: User successfully registered and Create Account button worked")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("FAIL: User could not register even with valid details")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration failed although valid details were provided.");
        }
    }
}
