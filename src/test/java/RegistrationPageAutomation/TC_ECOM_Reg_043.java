package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_043 extends BaseTest {

    @Test
    public void verifyInvalidAddress2Field() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_043 - Validate Address Line 2 with invalid input");

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

        // Step 3: Fill form with INVALID Address2
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "20", "August", "1992", false, true,
                "MyCompany", "789, Main Street", "!@#$%1234",   // ❌ Invalid Address2
                "India", "Kerala", "Kochi", "682001", "9876512345");
        test.info("Filled form with invalid Address2: !@#$%1234");

        // Step 4: Click Create Account
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_043");

        // Step 5: Verify result
        if (sp.isAccountCreated()) {
            test.fail("❌ FAIL: User was able to register with invalid Address2 input (!@#$%1234)")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Application failed to validate invalid Address2 input.");
        } else {
            test.pass("✅ PASS: User could not register with invalid Address2 input")
                .addScreenCaptureFromPath(shot);
        }
    }
}
