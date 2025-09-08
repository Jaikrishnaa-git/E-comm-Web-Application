package SmokeTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_Ecom_Sanity_007 extends BaseTest {

    @Test
    public void verifyVideoTutorialsNavigation() {
        // Create Extent Report entry
        test = extent.createTest("TC_Ecom_Sanity_007 - Verify Video Tutorials navigates to YouTube");

        try {
            // Step 1: Open Automation Exercise website
            driver.get("https://www.automationexercise.com");
            test.info("Opened Automation Exercise website");

            // Step 2: Click on 'Video Tutorials' link
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement videoTutorialsLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Video Tutorials')]")));
            videoTutorialsLink.click();
            test.info("Clicked on Video Tutorials link");

            // Step 3: Switch to the new window
            String originalWindow = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Step 4: Verify the current URL contains 'youtube.com'
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("youtube.com")) {
                test.pass("PASS - User is redirected to YouTube page");
            } else {
                test.fail("FAIL - User is NOT redirected to YouTube page. Current URL: " + currentUrl);
                Assert.fail("User is NOT redirected to YouTube page.");
            }

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
