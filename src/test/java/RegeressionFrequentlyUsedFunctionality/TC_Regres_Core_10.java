package RegeressionFrequentlyUsedFunctionality;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Regres_Core_10 extends BaseTest {

	@Test(groups = { "regression" })
    public void verifyScrollBarInProductPage() throws IOException {
        test = extent.createTest("TC_Regres_Core_10 - Verify Scroll Bar in Product Page");

        try {
            // Step 1 & 2: Open Products Page
            driver.get("https://automationexercise.com/products");
            test.info("Opened Products Page");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Step 3: Scroll Down
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            test.info("Scrolled down to bottom of the page");

            // Step 4: Scroll Up
            js.executeScript("window.scrollTo(0, 0)");
            test.info("Scrolled back up to top of the page");

            // Validate: if page height is greater than window height, scrollbar exists
            Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");
            Long windowHeight = (Long) js.executeScript("return window.innerHeight");

            boolean hasScroll = pageHeight > windowHeight;
            Assert.assertTrue(hasScroll, "Scroll bar is not available on Product page");
            test.pass("Scroll bar exists and user can move up & down");

            // Screenshot evidence
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_10");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Regres_Core_10_Fail");
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
