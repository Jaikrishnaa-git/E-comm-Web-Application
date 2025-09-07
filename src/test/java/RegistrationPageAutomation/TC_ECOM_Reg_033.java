package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_033 extends BaseTest {

    @Test
    public void verifyLastNameTextboxWithNoNameInSignupPage() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_033 - Verify Last Name Textbox with No Name in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials to reach account info section
        signup.newUserName("Test User");
        signup.enterEmail("TestUser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Leave Last Name empty
        signup.enterLastName(""); // no input provided

        // Try clicking Create Account button directly
        try {
            // Locate and click the Create Account button
            driver.findElement(org.openqa.selenium.By.xpath("//button[@data-qa='create-account']")).click();

            // Check for browser validation message
            String validationMsg = driver.findElement(org.openqa.selenium.By.id("last_name"))
                                        .getAttribute("validationMessage");

            if (validationMsg != null && !validationMsg.isEmpty()) {
                test.pass("Validation message displayed for empty Last Name field: " + validationMsg)
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_33"));
            } else {
                test.fail("No validation message displayed for empty Last Name field")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_33"));
                Assert.fail("Last Name textbox empty validation failed");
            }

        } catch (Exception e) {
            test.fail("Could not validate Last Name empty field scenario: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_33"));
            Assert.fail("Exception occurred while validating empty Last Name field");
        }
    }
}
