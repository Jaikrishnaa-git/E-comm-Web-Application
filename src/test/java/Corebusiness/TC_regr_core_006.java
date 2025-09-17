package Corebusiness;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_006 extends BaseTest {
    @Test(groups = {"regression"})
    public void verifyProduct() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Product verification");

        ProductsPage productpage = new ProductsPage(driver);
        productpage.openProductpage();
        productpage.clickProduct();

        String expectedURL = "https://automationexercise.com/product_details/1";
        if (driver.getCurrentUrl().equals(expectedURL)) {
            test.pass("Product available");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_006");
            test.fail("Product not available")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Product not available at expected URL: " + expectedURL);
        }

        softAssert.assertAll();
    }
}
