package SmokeTesting;

import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_Ecom_Sanity_009 extends BaseTest {

    @Test
    public void verifyAndValidateSiteStability() {
        // Create test in Extent Report
        ExtentTest test = extent.createTest("TC_Ecom_Sanity_009 - Verify and Validate Site Stability");

        // Get browser name
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        test.info("Browser launched: " + browserName);

        try {
            // Step 1: Open the URL
            driver.get("https://www.automationexercise.com/");
            test.info("Opened URL: https://www.automationexercise.com/");

            // Step 2: Verify the site loads successfully
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Automation Exercise"));

            test.pass("The website is stable and loaded successfully on browser: " + browserName);

        } catch (Exception e) {
            test.fail("Website stability verification failed due to exception: " + e.getMessage());
        }
    }
}
