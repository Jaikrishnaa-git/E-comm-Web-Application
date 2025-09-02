package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;


public class TC_ECOM_Reg_005 extends BaseTest{
	
  static String projectpath=System.getProperty("user.dir");
  
  @Test(dataProvider="logindata")
  public void verifySignup(String userName,String mailId) throws InterruptedException, IOException 
  {
	  String URL = "https://automationexercise.com/";
	  driver.get("https://automationexercise.com/");
	  ExtentTest test = extent.createTest("login with the valid Credentials "+userName+" "+mailId);
	  SignupPage signup = new SignupPage(driver);
	  signup.clickSignupLoginLink();
	  signup.enterSignupDetails(userName,mailId);
	  Thread.sleep(3000);
	  if(!driver.getCurrentUrl().equals(URL))
	  {
		test.pass("Naviagted to registration page sucessfully");
			
	  }
	  else
	  {
		test.fail("Naviagted to registration page unsucessful "+userName+" "+mailId).addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "Verify Signup"));
      }
 }
  
  @DataProvider
  public Object[][] logindata() throws IOException
  {
		return ExcelUtilities.getdata(projectpath+"\\src\\test\\resources\\Testdata\\data.xlsx", "Sheet1");
  }
}

