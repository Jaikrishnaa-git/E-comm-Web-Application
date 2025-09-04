package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_038 extends BaseTest {

    @Test
    public void verifyValidAddressField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_038 - Validate Address field with valid input");

        SignupPage sp = new SignupPage(driver);

        sp.openHome();
        test.info("Opened Home URL");

        sp.goToSignupLogin();
        test.info("Opened Signup/Login page");

        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        sp.fillFullAccountForm("Mr", "Keshav", "Sharma", "Test@123",
                "15", "May", "1995", true, true,
                "OpenAI", "2/45 , no 234 , Chennai", "Near Metro",
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");
        test.info("Filled account form with all details (including valid Address)");
        test.pass("✅ Validation successful: Address accepted correctly");

        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_038");
        if (sp.isAccountCreated()) {
            test.pass("✅ User successfully registered with valid Address")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("❌ FAIL: Account was not created even with valid Address")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Account was not created even with valid Address");
        }
    }
}
