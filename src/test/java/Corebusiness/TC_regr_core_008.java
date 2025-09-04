package Corebusiness;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_008 extends BaseTest {
  @Test
  public void verifyProduct() throws IOException, InterruptedException {
	  driver.get("https://automationexercise.com/");
      ExtentTest test = extent.createTest("Dropdown verification");
      ProductsPage productpage = new ProductsPage(driver);
      productpage.openProductpage();
      Thread.sleep(2000);
      if(productpage.clickProduct2())
      {
    	  test.pass("Quantity is visble");
      }
      else
      {
    	  test.fail("Quantity is not visble").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_regr_core_008"));
      }
     
  }
  
}
