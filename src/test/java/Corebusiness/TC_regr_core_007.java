package Corebusiness;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_007 extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyProduct() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("View Product verification");

        ProductsPage productpage = new ProductsPage(driver);
        productpage.openProductpage();
        productpage.clickProduct();

        String expectedURL = "https://automationexercise.com/product";
        if (!driver.getCurrentUrl().equals(expectedURL)) {
            test.pass("View product working");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_007");
            test.fail("View product not working")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("View product not working at URL: " + expectedURL);
        }

        softAssert.assertAll();
    }
}
