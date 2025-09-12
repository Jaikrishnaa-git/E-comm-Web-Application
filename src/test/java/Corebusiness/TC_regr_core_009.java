package Corebusiness;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_regr_core_009 extends BaseTest {

	@Test
    public void verifyProductPriceInProductPage() throws IOException {
        test = extent.createTest("TC_regr_core_009 - Verify Product Price in Product Page");

        try {
          
            driver.get("https://automationexercise.com/products");
            test.info("Opened Products Page");

     
            List<WebElement> prices = driver.findElements(By.cssSelector(".productinfo p"));

            if (prices.size() > 0) {
                boolean allVisible = true;
                for (WebElement price : prices) {
                    if (!price.isDisplayed()) {
                        allVisible = false;
                        break;
                    }
                }

                Assert.assertTrue(allVisible, "Some product prices are not visible");
                test.pass("All product prices are visible on the Product page");

             
                String shot = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_009");
                test.addScreenCaptureFromPath(shot);
            } else {
                String shot = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_009_NoPrice");
                test.fail("No product prices found on Product page").addScreenCaptureFromPath(shot);
                Assert.fail("No product prices found on Product page");
            }

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_009_Exception");
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}