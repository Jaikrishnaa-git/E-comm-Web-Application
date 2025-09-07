package RegistrationPageAutomation;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_ECOM_Reg_061 extends BaseTest {

    @Test
    public void verifyShowPasswordEyeButton() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_061 - Validate show password (eye) button");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Navigate to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login page");

        // Generate unique email and start signup
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Test@123");
        test.info("Entered password in the password field");

        // Step 4: Check if "eye" button exists
        List<WebElement> eyeBtn = driver.findElements(
            By.xpath("//input[@id='password']/following-sibling::*[contains(@class,'eye')]")
        );

        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_061_NoEyeBtn");

        if (eyeBtn.isEmpty()) {
            test.fail("FAIL: No show password (eye) button exists on the page. User cannot view password as text.")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Show password button not found.");
        } else {
            test.fail("FAIL: Unexpectedly found a show password button. This contradicts expected behavior.")
                .addScreenCaptureFromPath(shot);
            Assert.fail("Unexpected element found for show password.");
        }
    }
}
