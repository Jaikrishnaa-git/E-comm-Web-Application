package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_027 extends BaseTest {

    @Test
    public void verifyNewsletterCheckboxInSignupPage() throws IOException {
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_027 - Verify Newsletter Checkbox in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 1 & 2: Enter valid credentials and signup
        signup.startSignup(
            "TestUser",
            "testuser" + System.currentTimeMillis() + "@gmail.com"
        );

        // Step 3: Validate newsletter checkbox is displayed
        if (signup.isNewsletterCheckboxDisplayed()) {
            test.pass("Newsletter checkbox is displayed on the signup page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_27"));
        } else {
            test.fail("Newsletter checkbox is NOT displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_27"));
            Assert.fail("Newsletter checkbox not displayed");
        }

        // Step 4: Select the checkbox
        signup.clickNewsletterCheckbox();

        if (signup.isNewsletterCheckboxSelected()) {
            test.pass("Newsletter checkbox was successfully checked")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_27"));
        } else {
            test.fail("Newsletter checkbox could not be checked")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_27"));
            Assert.fail("Newsletter checkbox selection failed");
        }
    }
}
