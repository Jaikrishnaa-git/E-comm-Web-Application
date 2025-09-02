package RegistrationPageAutomation;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_ECOM_Reg_001 extends BaseTest {
	
   
    @Test
    public void browserVerify() throws InterruptedException {
        ExtentTest test = extent.createTest("Checking browser in Registration page");

        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        test.info("Browser launched: " + browserName);
        driver.get("https://automationexercise.com/");
        Thread.sleep(3000);
        test.info("Navigated to automationexercise.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.titleIs("Automation Exercise"));

            test.pass("Registration Page loads successfully on the " + browserName + " browser");
        } catch (Exception e) {
            test.fail("Registration Page did not load correctly on the " + browserName + " browser");
        }
    }
}
