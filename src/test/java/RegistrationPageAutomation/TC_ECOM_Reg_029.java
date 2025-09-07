package RegistrationPageAutomation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_029 extends BaseTest {

    @Test
    public void verifyFirstNameTextboxInSignupPage() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_029 - Verify First Name Textbox in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials to reach account info section
        signup.newUserName("sai");
        signup.enterEmail("sai" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Wait for First Name textbox to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));

        // Step 4: Enter First Name
        signup.enterFirstName("sai");

        // Step 5: Wait until the value is updated in the textbox
        wait.until(ExpectedConditions.attributeToBe(By.id("first_name"), "value", "sai"));

        // Step 6: Validate the entered value
        String enteredName = signup.getFirstNameValue();
        if ("sai".equals(enteredName)) {
            test.pass("First Name textbox contains the valid name: " + enteredName)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_29"));
        } else {
            test.fail("First Name textbox does not contain the valid name")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_29"));
            Assert.fail("First Name textbox validation failed");
        }
    }
}
