package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_040 extends BaseTest {

    @Test
    public void verifyInvalidAddressField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_040 - Validate invalid Address input");

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
                "MyCompany", "", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");

        sp.submitCreateAccount();
        String shot1 = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_040_Empty");

        if (sp.isAccountCreated()) {
            test.fail("❌ FAIL: User was able to register with EMPTY Address")
                .addScreenCaptureFromPath(shot1);
            Assert.fail("Application allowed EMPTY Address input.");
        } else {
            test.pass("✅ PASS: Registration blocked for EMPTY Address as expected")
                .addScreenCaptureFromPath(shot1);
        }

        driver.navigate().refresh();

     
        String email2 = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email2);

        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "MyCompany", "!@#$%1234", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");

        sp.submitCreateAccount();
        String shot2 = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_040_Special");

        if (sp.isAccountCreated()) {
            test.info("ℹ️ INFO: System accepted special char address (!@#$%1234)")
                .addScreenCaptureFromPath(shot2);
        } else {
            test.pass("✅ PASS: Registration blocked for special char Address as expected")
                .addScreenCaptureFromPath(shot2);
        }
    }
}
