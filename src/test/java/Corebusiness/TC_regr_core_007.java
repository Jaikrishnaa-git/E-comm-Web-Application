package Corebusiness;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_007 extends BaseTest {
  @Test
  public void verifyProduct() throws IOException {
	  driver.get("https://automationexercise.com/");
      ExtentTest test = extent.createTest("Dropdown verification");
      ProductsPage productpage = new ProductsPage(driver);
      productpage.openProductpage();
      productpage.clickProduct();
      String expectedURL = "https://automationexercise.com/product";
     
      if(!driver.getCurrentUrl().equals(expectedURL))
      {
    	  test.pass("View product working");
      }
      else
      {
    	  test.fail("View product not working").addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver,"TC_regr_core_007"));
      }
     
  }
  
}
