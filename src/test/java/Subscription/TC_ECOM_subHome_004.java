package Subscription;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_subHome_004 extends BaseTest{
  @Test
  public void verifySubsscription() throws IOException {
	  driver.get("https://automationexercise.com/");
	  ExtentTest test = extent.createTest("Verify Subscription email box");
	  HomePage home = new HomePage(driver);
	  if(home.isSubScriptionVisible())
	  {
		  test.pass("Subscription feild in home page is visible");
	  }
	  else
	  {
		  test.fail("Subscription feild not visible in home page").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_ECOM_subHome_001 "));
	  }
  }
}
