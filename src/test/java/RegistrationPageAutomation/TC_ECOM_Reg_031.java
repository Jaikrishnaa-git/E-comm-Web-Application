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

public class TC_ECOM_Reg_031 extends BaseTest {

    @Test
    public void verifyFirstNameWithInvalidInput() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_031 - Verify First Name textbox with invalid input in Signup Page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials and click Signup
        signup.newUserName("TestUser");
        signup.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Wait for Account Information page to load (First Name textbox visible)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));

        // Step 4: Enter invalid First Name
        String invalidName = "123455";
        signup.enterFirstName(invalidName);

        // Step 5: Click Create Account button
        By createAccountBtn = By.xpath("//button[text()='Create Account']");
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();

        // Step 6: Check whether the value is accepted
        String enteredName = signup.getFirstNameValue();
        if (enteredName.matches("[a-zA-Z]+")) {
            test.pass("First Name textbox contains a valid name after entering invalid input")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_31"));
        } else {
            test.fail("Invalid First Name accepted: " + enteredName)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_31"));
            Assert.fail("Invalid First Name validation failed; user is able to register with invalid name");
        }
    }
}
