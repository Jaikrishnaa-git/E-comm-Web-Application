package RegeressionFrequentlyUsedFunctionality;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Core_07 extends BaseTest {

	@Test(groups = { "regression" })
    public void verifyViewProductButton() throws IOException {
        test = extent.createTest("TC_Regres_Core_07 - Verify View Product button on Products Page");

        try {
            // Step 1 & 2: Open Products Page
            driver.get("https://automationexercise.com/products");
            test.info("Opened Products Page");

            // Step 3: Click on View Product button (first product)
            WebElement viewProductBtn = driver.findElement(By.xpath("//a[contains(text(),'View Product')]"));
            viewProductBtn.click();
            test.pass("Clicked on View Product button");

            // Step 4: Verify redirection to product details page
            boolean isOnProductDetail = driver.getCurrentUrl().contains("product_details");
            Assert.assertTrue(isOnProductDetail, "Did not navigate to product details page");
            test.pass("Successfully navigated to Product Details page");

            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_07");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_07_Fail");
            test.fail("❌ Exception: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
