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

public class TC_ECOM_Reg_030 extends BaseTest {

    @Test
    public void verifyFirstNameEmptyOnAccountInfo() throws IOException {
        // Step 1: Open the signup page URL
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_030 - Verify First Name textbox empty in Account Info page");

        SignupPage signup = new SignupPage(driver);

        // Step 2: Enter valid signup credentials and click Signup
        signup.newUserName("TestUser");
        signup.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Wait for Account Information page to load (First Name textbox visible)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));

        // Step 4: Leave First Name empty
        signup.enterFirstName("");  // Clear field if needed

        // Step 5: Click Create Account button
        By createAccountBtn = By.xpath("//button[text()='Create Account']");
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();

        // Step 6: Check for validation message (HTML5 required field)
        String firstNameValidation = driver.findElement(By.id("first_name")).getAttribute("validationMessage");
        if (firstNameValidation != null && !firstNameValidation.isEmpty()) {
            test.pass("Validation message displayed for empty First Name: " + firstNameValidation)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_30"));
        } else {
            test.fail("No validation message displayed for empty First Name")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_RegPage_30"));
            Assert.fail("First Name empty field validation failed");
        }
    }
}
