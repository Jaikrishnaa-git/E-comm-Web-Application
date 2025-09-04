package RegistrationPageAutomation;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_039 extends BaseTest {

    @Test
    public void verifyEmptyAddressField() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_039 - Validate empty Address field in Signup");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Go to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login");

        // Create a unique email
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Fill form with EMPTY Address1
        sp.fillFullAccountForm("Mr", "Keshav", "Test", "Test@123",
                "10", "June", "1990", true, true,
                "MyCompany", "", "Address Line 2",   // ✅ EMPTY Address1
                "India", "Tamil Nadu", "Chennai", "600001", "9876543210");
        test.info("Filled form with EMPTY Address field");

        // Step 4: Try submitting
        WebElement address1Field = driver.findElement(By.id("address1"));
        sp.submitCreateAccount();

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_039");

        // ✅ Check HTML5 validation message using JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", address1Field);

        if (validationMsg != null && !validationMsg.isEmpty()) {
            test.pass("✅ PASS: Validation message displayed for empty Address field → " + validationMsg)
                .addScreenCaptureFromPath(shot);
            Assert.assertTrue(true, "Validation successful: " + validationMsg);
        } else if (!sp.isAccountCreated()) {
            test.pass("✅ PASS: Registration blocked due to empty Address field.")
                .addScreenCaptureFromPath(shot);
            Assert.assertTrue(true, "Validation successful: Registration did not proceed.");
        } else {
            test.fail("❌ FAIL: User was able to register with EMPTY Address field.")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Registration went through with invalid input (empty address).");
        }
    }
}
