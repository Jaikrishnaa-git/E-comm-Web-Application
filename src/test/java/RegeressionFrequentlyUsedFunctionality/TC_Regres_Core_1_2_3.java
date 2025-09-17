package RegeressionFrequentlyUsedFunctionality;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Core_1_2_3 extends BaseTest {

    String baseUrl = "https://automationexercise.com/";
    String validEmail = "kbharadwaj@gmail.com";    
    String validPassword = "123456";       

    @Test(priority = 1, groups = { "regression" })
    public void TC1_verifyValidEmailField() throws IOException {
        test = extent.createTest("TC1 - Verify valid Email Address in Login Page");

        try {
            driver.get(baseUrl);
            driver.findElement(By.linkText("Signup / Login")).click();
            test.info("Opened Login/Signup Page");

            driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                  .sendKeys(validEmail);
            test.info("Entered valid email: " + validEmail);

            String enteredEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']")).getAttribute("value");
            Assert.assertEquals(enteredEmail, validEmail, "Email not entered correctly");
            test.pass("Valid email address accepted");

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC1_Fail");
            test.fail("Exception: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test(priority = 2, groups = { "regression" })
    public void TC2_verifyValidPasswordField() throws IOException {
        test = extent.createTest("TC2 - Verify valid Password in Login Page");

        try {
            driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                  .sendKeys(validPassword);
            test.info("Entered valid password");

            String enteredPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']")).getAttribute("value");
            Assert.assertEquals(enteredPassword, validPassword, "Password not entered correctly");
            test.pass("Valid password accepted");

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC2_Fail");
            test.fail("Exception: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test(priority = 3, groups = { "regression" })
    public void TC3_verifyLoginButton() throws IOException {
        test = extent.createTest("TC3 - Verify Login Button with Valid Credentials");

        try {
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
            test.info("Clicked on Login button");

            boolean isLoggedIn = driver.findElements(By.xpath("//a[contains(text(),'Logged in as')]")).size() > 0;

            if (isLoggedIn) {
                test.pass("User successfully logged in with valid credentials");
                String shot = ScreenshotUtilities.capturescreen(driver, "TC3_Pass");
                test.addScreenCaptureFromPath(shot);
            } else {
                String shot = ScreenshotUtilities.capturescreen(driver, "TC3_Fail");
                test.fail("Login failed with valid credentials").addScreenCaptureFromPath(shot);
                Assert.fail("Login failed with valid credentials");
            }

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC3_Exception");
            test.fail("Exception: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
