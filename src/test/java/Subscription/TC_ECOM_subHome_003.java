package Subscription;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_subHome_003 extends BaseTest{
  static String projectpath=System.getProperty("user.dir");
  
@Test(dataProvider ="homePageData")
  public void verifySubsscription(String email,String dummy) throws IOException, InterruptedException {
	  driver.get("https://automationexercise.com/");
	  email="";
	  ExtentTest test = extent.createTest("Verify Subscription email box");
	  HomePage home = new HomePage(driver);
	  System.out.println(email);
	  Thread.sleep(3000);
	  home.enterSubsciptionMail(email);
	  if(!home.isSubSubmittedDisplayed())
	  {
		  test.pass("Subscription without mail not allowed");
	  }
	  else
	  {
		  test.fail("Subscribed with no email").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_ECOM_subHome_001"));
		  Assert.fail("Subscribed with no Email");
	  }
	  
  }
  @DataProvider
  public Object[][] homePageData()
  {
	  try {
          System.out.println(">>> Loading data from Excel...");
		  Object[][] data = ExcelUtilities.getdata(projectpath + "\\src\\test\\resources\\Testdata\\Subscription data.xlsx", "no email");
          System.out.println(">>> Data loaded: " + data.length + " rows");
          return data;
      } catch (Exception e) {
          System.out.println(">>> ERROR reading Excel: " + e.getMessage());
          e.printStackTrace();
          return new Object[0][0]; 
      }
  }
}
