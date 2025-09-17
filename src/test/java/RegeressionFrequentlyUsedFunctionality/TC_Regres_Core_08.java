package RegeressionFrequentlyUsedFunctionality;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Core_08 extends BaseTest {

	@Test(groups = { "regression" })
    public void verifyProductButton() throws IOException {
        test = extent.createTest("TC_Regres_Core_08 - Verify Product Button on Products Page");

        try {
            // Step 1 & 2: Open Home Page
            driver.get("https://automationexercise.com/");
            test.info("Opened Home Page");

            // Step 3: Click on Products button in the navigation menu
            WebElement productsBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productsBtn.click();
            test.pass("Clicked on Products button");

            // Step 4: Verify Products Page is displayed
            boolean isProductsPage = driver.getCurrentUrl().contains("products");
            Assert.assertTrue(isProductsPage, "Products Page did not load properly");
            test.pass("Successfully navigated to Products Page");

            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_08");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_08_Fail");
            test.fail("❌ Exception: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
