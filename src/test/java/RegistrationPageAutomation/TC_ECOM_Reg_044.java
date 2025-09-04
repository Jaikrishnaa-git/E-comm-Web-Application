package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_044 extends BaseTest {

    @Test
    public void verifyValidStateField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_044 - Validate State field with valid input");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Navigate to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login");

        // Unique email
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Fill form with valid State = Tamilnadu
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "15", "July", "1995", true, true,
                "MyCompany", "12, Gandhi Street", "Near Park",
                "India", "Tamilnadu", "Chennai", "600100", "9876543210");
        test.info("Filled form with valid State: Tamilnadu");

        // Step 4: Submit Create Account
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_044");

        // Step 5: Verify result
        if (sp.isAccountCreated()) {
            test.pass("✅ PASS: User successfully registered with valid State input")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("❌ FAIL: Registration failed even with valid State input")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Application did not allow registration with valid State field.");
        }
    }
}
