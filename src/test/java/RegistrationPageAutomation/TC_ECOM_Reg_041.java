package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_041 extends BaseTest {

    @Test
    public void verifyValidAddress2Field() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_041 - Validate Address Line 2 with valid address");

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

        // Step 3: Fill form with VALID Address2
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "MyCompany", "123, Main Street", "2/45 , no 234 , Chennai",  // ✅ Valid Address2
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");
        test.info("Filled form with valid Address2: 2/45 , no 234 , Chennai");

        // Step 4: Click Create Account
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_041");

        // Step 5: Verify result
        if (sp.isAccountCreated()) {
            test.pass("✅ PASS: User successfully registered with valid Address2")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("❌ FAIL: User could NOT register with valid Address2")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration failed despite valid Address2 input.");
        }
    }
}
