package Corebusiness;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_008 extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyProduct() throws IOException, InterruptedException {
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Product quantity verification");
        ProductsPage productpage = new ProductsPage(driver);
        productpage.openProductpage();
        Thread.sleep(2000);

        if (productpage.clickProduct2()) {
            test.pass("Quantity is visible");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_008");
            test.fail("Quantity is not visible").addScreenCaptureFromPath(screenshotPath);
            Assert.fail("Quantity is not visible");
        }
    }
}
