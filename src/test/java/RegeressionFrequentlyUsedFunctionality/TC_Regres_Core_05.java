package RegeressionFrequentlyUsedFunctionality;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_Regres_Core_05 extends BaseTest {

	@Test(groups = { "regression" })
    public void verifyLogoOnProductPage() throws IOException {
        test = extent.createTest("TC_Regres_Core_05 - Verify Logo on Product Page");
        SoftAssert softAssert = new SoftAssert();

        // Step 1: Open Product Page directly
        driver.get("https://automationexercise.com/products");
        test.info("Opened Product Page");

        try {
            // Step 2: Verify logo is visible
            By logo = By.xpath("//img[@alt='Website for automation practice']");
            boolean isLogoDisplayed = driver.findElement(logo).isDisplayed();
            softAssert.assertTrue(isLogoDisplayed, "Logo is not visible on Product page");
            test.pass("Logo is displayed on Product Page");

            // Step 3: Click on logo
            driver.findElement(logo).click();
            test.info("Clicked on Logo");

            // Step 4: Validate redirect (logo should bring back to homepage)
            boolean isHomeLoaded = driver.getCurrentUrl().equals("https://automationexercise.com/");
            softAssert.assertTrue(isHomeLoaded, "Clicking on logo did not redirect to Home Page");
            test.pass("Clicking on Logo redirected to Home Page successfully");

            // Capture screenshot
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_05");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_05_Fail");
            test.fail("Exception while validating Logo: " + e.getMessage())
                .addScreenCaptureFromPath(shot);
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Final assertion
        softAssert.assertAll();
        Assert.assertTrue(true, "Logo verification completed");
    }
}
