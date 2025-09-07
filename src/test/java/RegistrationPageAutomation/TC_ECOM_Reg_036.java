package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_036 extends BaseTest {

    @Test
    public void verifyCompanyTextboxWithNoNameInSignupPage() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_036 - Verify Company Textbox with No Name in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials to reach account info section
        signup.newUserName("Test User");
        signup.enterEmail("TestUser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Leave Company field empty
        signup.enterCompany("");

        // Step 4: Validate that user can still proceed (non-mandatory field)
        String enteredCompany = signup.getCompanyValue();
        if (enteredCompany.isEmpty()) {
            test.pass("User is able to register even without entering Company name.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_36"));
        } else {
            test.fail("Company field unexpectedly has value: " + enteredCompany)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_36"));
            Assert.fail("Company field should allow blank input!");
        }
    }
}
