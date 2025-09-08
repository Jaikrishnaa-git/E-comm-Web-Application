package SmokeTesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_Ecom_Sanity_003 extends BaseTest {

    @Test
    public void verifyProductDisplay() throws IOException {
        test = extent.createTest("TC_Ecom_Sanity_003 - Verify Product Display");

        HomePage home = new HomePage(driver);

        // Step 1: Open home page
        home.open();
        test.info("Opened Home Page");
        Assert.assertTrue(home.isHomePageVisible(), "❌ Home page did not load properly.");
        test.pass("✅ Home Page loaded successfully");

        try {
            // Step 2: Navigate to Products Page
            home.clickProducts();
            test.info("Navigated to Products Page");

            // Step 3: Verify products are displayed
            boolean productsVisible = driver.findElements(By.xpath("//div[@class='features_items']/div")).size() > 0;
            Assert.assertTrue(productsVisible, "❌ Products are not displayed on Products Page.");
            test.pass("✅ Products are displayed successfully");

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Ecom_Sanity_003_Fail");
            test.fail("❌ Product display validation failed: " + e.getMessage())
                .addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
