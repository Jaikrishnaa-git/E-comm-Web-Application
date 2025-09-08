package RegistrationPageAutomation;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;


public class TC_ECOM_Reg_007 extends BaseTest{
	
  static String projectpath=System.getProperty("user.dir");
  
  @Test(dataProvider = "logindata")
  public void verifySignup(String userName, String mailId) throws InterruptedException, IOException {
      String expectedURL = "https://automationexercise.com/login";
      driver.get("https://automationexercise.com/");
      ExtentTest test = extent.createTest("Signup Test with Name: " + userName + " and Email: [" + mailId + "]");

      SignupPage signup = new SignupPage(driver);
      signup.clickSignupLoginLink();
      test.info("Testing with empty email field.");
      signup.enterSignupDetails(userName, mailId);

      Thread.sleep(3000); 

      String currentURL = driver.getCurrentUrl();
      if (!currentURL.equals(expectedURL)) {
          test.fail("Unexpectedly navigated to another page despite invalid email.")
              .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "Unexpected_Navigation_TC_ECOM_Reg_007"));
      } else {
          test.pass("Stayed on login page as expected when email was invalid.");
      }
  }

  
  @DataProvider
  public Object[][] logindata() {
      try {
          System.out.println(">>> Loading data from Excel...");
          Object[][] data = ExcelUtilities.getdata(projectpath + "\\src\\test\\resources\\Testdata\\data.xlsx", "valid name invalid email");
          System.out.println(">>> Data loaded: " + data.length + " rows");
          return data;
      } catch (Exception e) {
          System.out.println(">>> ERROR reading Excel: " + e.getMessage());
          e.printStackTrace();
          return new Object[0][0]; 
      }
  }


}

