package APITesting_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;
import java.util.Set;

public class TC_Ecommerce_Web_Application_API_Testing_28 extends BaseTest {

    @Test
    public void verifyFeedbackLink() {
        ExtentTest test = extent.createTest("TC_Ecommerce_Web_Application_API_Testing_28 - Verify Feedback Email Link");

        try {
            // Open API Testing page
            driver.get("https://automationexercise.com/api_list");
            test.info("Navigated to API Testing page");

            // Wait for feedback email link to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement feedbackEmailLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//u[contains(text(),'feedback@automationexercise.com')]")));
            test.info("Feedback email link is visible and clickable");

            // Store current window handle before clicking
            String parentWindow = driver.getWindowHandle();

            // Click on the email link
            feedbackEmailLink.click();
            test.info("Clicked on feedback email link");

            // Wait for new window/tab to open
            Thread.sleep(2000); // Small wait to ensure new window opens

            // Get all open windows
            Set<String> allWindows = driver.getWindowHandles();

            // Switch to new window if opened
            for (String window : allWindows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    test.info("Switched to newly opened feedback window/tab");
                    driver.close();  // Close the email client window
                    test.pass("Feedback email link clicked successfully and window closed");
                }
            }

            // Switch back to the main window
            driver.switchTo().window(parentWindow);
            test.info("Switched back to the main API Testing page");

            // Final assertion to confirm we are back on the main page
            Assert.assertTrue(driver.getCurrentUrl().contains("api_list"), "Failed to return to main page!");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }
}
