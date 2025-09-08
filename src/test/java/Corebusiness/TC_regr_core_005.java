package Corebusiness;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_005 extends BaseTest{
  @Test
  public void verifyBrands() throws IOException 
  {
	  driver.get("https://automationexercise.com/");
      ExtentTest test = extent.createTest("Dropdown verification");
      ProductsPage productpage = new ProductsPage(driver);
      productpage.openProductpage();
      if( productpage.isBrandVisible())
      {
   	   test.pass("All brand links are visible");
      }
      else
      {
   	   test.fail("Brand links are not visible").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_regr_core_004"));
      }
   }
}
