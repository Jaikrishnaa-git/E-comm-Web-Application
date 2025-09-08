package ProductPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_TestCase_1 extends BaseTest {

    @Test
    public void verifyLogoOnProductPage() throws IOException {
        // Start Extent Report Test
        ExtentTest test = extent.createTest("TC_ECOM_TestCase_1 - Verify Logo on Product Page");
        


        // Open the Product Page URL
        driver.get("https://automationexercise.com/product");

        // Locate the Logo Element
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png' and @alt='Website for automation practice']"));

        // Check if Logo is Displayed
        if (logo.isDisplayed()) {
            test.pass("Logo is displayed on the Product Page");
        } else {
            test.fail("Logo is NOT displayed on the Product Page")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "LogoNotDisplayed"));
            Assert.fail("Logo is not displayed");
        }

        // Check if Logo is Clickable
        try {
            logo.click();
            test.pass("Logo is clickable and navigation is successful");
        } catch (Exception e) {
            test.fail("Logo is NOT clickable")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "LogoNotClickable"));
            Assert.fail("Logo is not clickable: " + e.getMessage());
        }
    }
}
