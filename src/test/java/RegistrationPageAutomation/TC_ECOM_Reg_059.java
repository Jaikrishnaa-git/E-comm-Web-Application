package RegistrationPageAutomation;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TC_ECOM_Reg_059 extends BaseTest {

    @Test
    public void verifyAdvertisementVideoOnSignupPage() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_059 - Validate advertisement video on Signup page");

        SignupPage sp = new SignupPage(driver);

        // Step 1: Open Home
        sp.openHome();
        test.info("Opened Home URL");

        // Step 2: Navigate to Signup/Login
        sp.goToSignupLogin();
        test.info("Navigated to Signup/Login page");

        // Generate a unique email and start signup
        String email = "auto" + System.currentTimeMillis() + "@test.com";
        sp.startSignup("Keshav", email);
        test.info("Entered new user details and moved to Account Info page");

        // Step 3: Look for Advertisement iframe/video
        List<WebElement> adFrames = driver.findElements(By.cssSelector("iframe[id^='aswift_']"));

        if (adFrames.isEmpty()) {
            test.info("No Advertisement video found on Signup page.");
            System.out.println("No Advertisement video found on Signup page.");
            return; // exit gracefully
        }

        try {
            // Switch to first advertisement iframe
            driver.switchTo().frame(adFrames.get(0));

            // Try to locate video element inside ad
            List<WebElement> videos = driver.findElements(By.tagName("video"));

            if (videos.isEmpty()) {
                test.info("Ad frame present but no video element found.");
                System.out.println("Ad frame present but no video element found.");
                return;
            }

            WebElement video = videos.get(0);

            // Play video using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].play()", video);

            // Wait briefly to confirm play
            Thread.sleep(3000);

            // Check if video is playing (not paused)
            Boolean isPaused = (Boolean) js.executeScript("return arguments[0].paused;", video);

            // Capture screenshot
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_059");

            if (!isPaused) {
                test.pass("PASS: Advertisement video is playing successfully.")
                    .addScreenCaptureFromPath(shot);
            } else {
                test.fail("FAIL: Advertisement video did not play.")
                    .addScreenCaptureFromPath(shot);
                Assert.fail("Video is still paused after clicking play.");
            }

        } catch (Exception e) {
            test.info("Error while interacting with Advertisement video: " + e.getMessage());
            System.out.println("Exception while verifying ad video: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
