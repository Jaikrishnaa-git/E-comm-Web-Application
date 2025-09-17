package RegistrationPageAutomation;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.time.Duration;

public class TC_ECOM_Reg_001 extends BaseTest {

    @Test
    public void browserVerify() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Checking browser in Registration page");
        String expectedURL = "https://automationexercise.com/login";
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        test.info("Browser launched: " + browserName);

        driver.get("https://automationexercise.com/");
        SignupPage signup = new SignupPage(driver);
        signup.clickSignupLoginLink();
        Thread.sleep(3000);
        test.info("Navigated to automationexercise.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("login"));

        if (driver.getCurrentUrl().equals(expectedURL)) {
            test.pass("Registration page loads on " + browserName);
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_001");
            test.fail("Registration page does not load on " + browserName).addScreenCaptureFromPath(screenshotPath);
            Assert.fail("Registration page does not load on " + browserName);
        }
    }
}
