package Corebusiness;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.LoginPage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;


public class TC_regr_core_001 extends BaseTest{
    static String projectPath = System.getProperty("user.dir");
    @Test(dataProvider = "logindata")
    public void f(String email, String password) throws InterruptedException, IOException
    {
    		
       driver.get("https://automationexercise.com/");
       ExtentTest test = extent.createTest("Login Test with Name: " + email + " and Email: "+password);
       LoginPage login = new LoginPage(driver);
       login.openLoginPage();
       login.loginCredentials(email,password);
       if(login.logoutDisplayed())
       {
    	   test.pass("Login with valid credentials sucessful");
       }
       else
       {
    	   test.fail("Login with valid credentials not sucessful").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_regr_core_002 "));
       }
       
    }

    @DataProvider
    public Object[][] logindata() {
        try {
            System.out.println(">>> Loading data from Excel...");
            Object[][] data = ExcelUtilities.getdata(projectPath + "\\src\\test\\resources\\Testdata\\data.xlsx", "Login valid Credentials");
            System.out.println(">>> Data loaded: " + data.length + " rows");
            return data;
        } catch (Exception e) {
            System.out.println(">>> ERROR reading Excel: " + e.getMessage());
            e.printStackTrace();
            return new Object[0][0]; 
        }
    }

}