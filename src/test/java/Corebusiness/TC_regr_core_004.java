package Corebusiness;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.ProductsPage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_004 extends BaseTest {
    static String projectPath = System.getProperty("user.dir");

    @Test(groups = {"regression"})
    public void verifyDropDown() throws InterruptedException, IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Dropdown verification");
        ProductsPage productpage = new ProductsPage(driver);

        if (productpage.verifyDropDown()) {
            test.pass("All Category drop downs are visible");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_004");
            test.fail("Category drop downs are not visible")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Category drop downs are not visible");
        }

        softAssert.assertAll();
    }
}
