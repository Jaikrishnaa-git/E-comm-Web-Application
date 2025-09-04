package RegistrationPageAutomation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_047 extends BaseTest {

    @Test
    public void verifyCountryDropdownClickable() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_047 - Validate Country dropdown is clickable");

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

        // Step 3: Validate Country dropdown is clickable
        WebElement countryDropdown = driver.findElement(By.id("country"));
        countryDropdown.click();
        test.info("Clicked on Country dropdown");

        // Capture screenshot
        String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_047");

        if (countryDropdown.isDisplayed() && countryDropdown.isEnabled()) {
            test.pass("✅ PASS: Country dropdown is clickable").addScreenCaptureFromPath(shot);
        } else {
            test.fail("❌ FAIL: Country dropdown is NOT clickable").addScreenCaptureFromPath(shot);
            Assert.fail("Country dropdown could not be clicked.");
        }
    }
}
