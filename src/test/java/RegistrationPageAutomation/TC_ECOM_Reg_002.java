package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_Reg_002 extends BaseTest {

    @Test
    public void checkNameField() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Checking name field in Registration page");

        driver.get("https://automationexercise.com/");
        SignupPage signup = new SignupPage(driver);

        signup.clickSignupLoginLink();
        Thread.sleep(3000);
        test.info("Navigated to automationexercise.com");

        try {
            if (signup.nameIsDisplayed()) {
                test.pass("The name field is displayed");
            } else {
                String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_002");
                test.fail("The name field is not displayed").addScreenCaptureFromPath(screenshotPath);
                Assert.fail("The name field is not displayed");
            }
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_002");
            test.fail("Name field not found. Exception: " + e.getMessage()).addScreenCaptureFromPath(screenshotPath);
            Assert.fail("Name field not found. Exception: " + e.getMessage());
        }
    }
}
