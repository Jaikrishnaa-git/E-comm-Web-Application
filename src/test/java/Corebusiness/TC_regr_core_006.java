package Corebusiness;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_006 extends BaseTest {
  @Test
  public void verifyProduct() throws IOException {
	  driver.get("https://automationexercise.com/");
      ExtentTest test = extent.createTest("Dropdown verification");
      ProductsPage productpage = new ProductsPage(driver);
      productpage.openProductpage();
      productpage.clickProduct();
      String expectedURL = "https://automationexercise.com/product_details/1";
     
      if(driver.getCurrentUrl().equals(expectedURL))
      {
    	  test.pass("Product available");
      }
      else
      {
    	  test.fail("Product not available : Product number").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_regr_core_006"));
      }
     
  }
  
}
