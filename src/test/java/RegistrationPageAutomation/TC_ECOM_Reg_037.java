package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_037 extends BaseTest {

    @Test
    public void verifyInvalidCompanyField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_037 - Invalid Company Field Validation");

        SignupPage sp = new SignupPage(driver);

        sp.openHome();
        test.info("Opened Home URL");

        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login");

        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "123455", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");
        test.info("Filled account form with INVALID Company: 123455");

        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_037");

        if (sp.isAccountCreated()) {
            test.fail("❌ FAIL: User was able to register with an INVALID company value.")
                .addScreenCaptureFromPath(shot);
            Assert.fail("User registered with invalid company name — validation FAILED.");
        } else {
            test.pass("✅ PASS: Application blocked registration with invalid company value.")
                .addScreenCaptureFromPath(shot);
            Assert.assertTrue(true, "Validation successful: invalid company was rejected.");
        }
    }
}
