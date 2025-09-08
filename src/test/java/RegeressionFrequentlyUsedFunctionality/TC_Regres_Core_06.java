package RegeressionFrequentlyUsedFunctionality;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Core_06 extends BaseTest {

    @Test
    public void verifyAddToCartButton() throws IOException {
        test = extent.createTest("TC_Regres_Core_06 - Verify Add to Cart button on Products Page");

        try {
            // Step 1 & 2: Open Product Page
            driver.get("https://automationexercise.com/products");
            test.info("Opened Products Page");

            // Step 3: Click on Add to Cart button (first one found)
            WebElement addToCartBtn = driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]"));
            addToCartBtn.click();
            test.pass("Clicked on Add to Cart button");

            // Step 4: Verify cart popup/confirmation
            boolean isAdded = driver.getPageSource().toLowerCase().contains("added");
            Assert.assertTrue(isAdded, "Add to Cart did not trigger confirmation");
            test.pass("Product successfully added to cart");

            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_06");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_06_Fail");
            test.fail("❌ Exception: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

