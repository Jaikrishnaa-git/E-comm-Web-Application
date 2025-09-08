package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_054_055 extends BaseTest {

    @Test
    public void verifyValidMobileField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_054 - Validate Mobile with valid input");

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

        // Step 3: Fill form with valid Mobile number
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "TestCompany", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");
        test.info("Filled account form with valid Mobile: 9876543210");

        // Step 4: Submit form
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_054");

        if (sp.isAccountCreated()) {
            test.pass("PASS: User successfully registered with valid Mobile")
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("FAIL: Registration failed with valid Mobile")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration failed with valid Mobile input.");
        }
    }

    @Test
    public void verifyEmptyMobileField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_055 - Validate Mobile with no input");

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

        // Step 3: Fill form but leave Mobile blank
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "TestCompany", "Address Line 1", "Address Line 2",
                "India", "Tamil Nadu", "Chennai", "600001", "");
        test.info("Filled account form with empty Mobile");

        // Step 4: Submit form
        sp.submitCreateAccount();
        test.info("Clicked Create Account");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_055");

        // Validate browser message for empty field
        String validationMsg = driver.findElement(sp.getMobileLocator()).getAttribute("validationMessage");

        if (validationMsg != null && validationMsg.contains("Please fill")) {
            test.pass("PASS: Validation message displayed for empty Mobile: " + validationMsg)
                .addScreenCaptureFromPath(shot);
        } else {
            test.fail("FAIL: No validation message for empty Mobile field")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Mobile field accepted empty input.");
        }
    }
}
