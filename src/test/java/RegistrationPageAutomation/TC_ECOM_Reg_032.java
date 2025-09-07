package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_032 extends BaseTest {

    @Test
    public void verifyLastNameTextboxInSignupPage() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_032 - Verify Last Name Textbox in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials to reach account info section
        signup.newUserName("Test User");
        signup.enterEmail("TestUser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Validate Last Name textbox is displayed
        if (signup.getLastNameValue() != null) {
            test.pass("Last Name textbox is displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_32"));

            // Enter Last Name
            signup.enterLastName("sai");

            // Validate the entered value
            String enteredLastName = signup.getLastNameValue();
            if ("sai".equals(enteredLastName)) {
                test.pass("Last Name textbox contains the valid name: " + enteredLastName)
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_32"));
            } else {
                test.fail("Last Name textbox does not contain the valid name")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_32"));
                Assert.fail("Last Name textbox validation failed");
            }

        } else {
            test.fail("Last Name textbox is NOT displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_32"));
            Assert.fail("Last Name textbox not displayed");
        }
    }
}
