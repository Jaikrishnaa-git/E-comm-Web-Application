package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_034 extends BaseTest {

    @Test
    public void verifyLastNameTextboxWithInvalidNameInSignupPage() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_034 - Verify Last Name Textbox with Invalid Name in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials to reach account info section
        signup.newUserName("Test User");
        signup.enterEmail("TestUser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Enter invalid last name (numbers instead of alphabets)
        signup.enterLastName("123455");

        // Step 4: Validate the entered value
        String enteredLastName = signup.getLastNameValue();
        if ("123455".equals(enteredLastName)) {
            test.fail("User is able to register with invalid Last Name: " + enteredLastName)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_34"));
            Assert.fail("Invalid Last Name accepted – Bug in application!");
        } else {
            test.pass("Invalid Last Name not accepted, validation working correctly")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_34"));
        }
    }
}
