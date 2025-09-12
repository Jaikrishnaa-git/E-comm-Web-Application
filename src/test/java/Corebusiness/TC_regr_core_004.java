package Corebusiness;

import java.io.IOException;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.Ecomm.pages.*;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_regr_core_004 extends BaseTest{
    static String projectPath = System.getProperty("user.dir");
    @Test(groups = {"regression"})
    public void verifyDropDown() throws InterruptedException, IOException
    {
    		
       driver.get("https://automationexercise.com/");
       ExtentTest test = extent.createTest("Dropdown verification");
       ProductsPage productpage = new ProductsPage(driver);
       if( productpage.verifyDropDown())
       {
    	   test.pass("All Category  drop downs are visible");
       }
       else
       {
    	   test.fail("Category drop downs are not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_regr_core_004"));
       }
    }
}