package RegistrationPageAutomation;

import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class TC_ECOM_Reg_003 extends BaseTest
{

	 	@Test
	    public void checkEmailField() throws InterruptedException, IOException {
		 ExtentTest  test = extent.createTest("Checking name field in Registration page");

	        driver.get("https://automationexercise.com/");
	        SignupPage signup = new SignupPage(driver);

	        signup.clickSignupLoginLink();
	        Thread.sleep(3000);
	        test.info("Navigated to automationexercise.com");

	        try {
	            if (signup.emailIsdisplayed()) {
	                test.pass("The email field is displayed");
	            } else {
	                test.fail("The email field is not displayed");
	                ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_003");
	            }
	        } catch (Exception e) {
	            test.fail("Name field not found. Exception: " + e.getMessage());
	            ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_003");
	        }
	    }
	}

