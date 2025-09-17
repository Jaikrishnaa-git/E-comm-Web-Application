package RegeressionFrequentlyUsedFunctionality;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Core_09 extends BaseTest {

	@Test(groups = { "regression" })
    public void verifyCartButtonFromProductPage() throws IOException {
        test = extent.createTest("TC_Regres_Core_09 - Verify Cart Button from Products Page");

        try {
            // Step 1 & 2: Open Products Page directly
            driver.get("https://automationexercise.com/products");
            test.info("Opened Products Page");

            // Step 3: Click on Cart button in navigation menu
            WebElement cartBtn = driver.findElement(By.xpath("//a[@href='/view_cart']"));
            cartBtn.click();
            test.pass("Clicked on Cart button");

            // Step 4: Verify Cart Page is displayed
            boolean isCartPage = driver.getCurrentUrl().contains("view_cart");
            Assert.assertTrue(isCartPage, "Cart Page did not load properly");
            test.pass("Successfully navigated to Cart Page");

            // Screenshot for evidence
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_09");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_09_Fail");
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
