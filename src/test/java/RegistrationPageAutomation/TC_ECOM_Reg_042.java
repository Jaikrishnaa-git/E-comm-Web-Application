package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_042 extends BaseTest {

    @Test
    public void verifyEmptyAddress2Field() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_042 - Validate Address Line 2 with no input");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Go to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login");

        // Unique email
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Fill form WITHOUT Address2
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "15", "July", "1991", true, false,
                "MyCompany", "456, Market Road", "",   // ✅ Blank Address2
                "India", "Tamil Nadu", "Chennai", "600002", "9876501234");
        test.info("Filled form with Address2 left empty");

        // Step 4: Click Create Account
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_042");

        // Step 5: Verify result
        if (sp.isAccountCreated()) {
            test.pass("✅ PASS: User successfully registered even with Address2 blank (field is non-mandatory)")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("❌ FAIL: User could not register with Address2 left empty (unexpected)")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration failed despite Address2 being non-mandatory.");
        }
    }
}
