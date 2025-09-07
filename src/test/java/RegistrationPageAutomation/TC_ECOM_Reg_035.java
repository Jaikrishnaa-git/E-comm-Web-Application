package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_035 extends BaseTest {

    @Test
    public void verifyCompanyTextboxWithValidNameInSignupPage() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_035 - Verify Company Textbox with Valid Name in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials to reach account info section
        signup.newUserName("Test User");
        signup.enterEmail("TestUser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Enter valid company name
        signup.enterCompany("CGI");

        // Step 4: Validate if Company field has correct value
        String enteredCompany = signup.getCompanyValue();
        if ("CGI".equals(enteredCompany)) {
            test.pass("User is able to register with valid Company name: " + enteredCompany)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_35"));
        } else {
            test.fail("Company field did not accept valid name. Entered: " + enteredCompany)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_35"));
            Assert.fail("Company field validation failed!");
        }
    }
}
