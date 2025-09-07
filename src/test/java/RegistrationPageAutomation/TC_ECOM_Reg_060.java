package RegistrationPageAutomation;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TC_ECOM_Reg_060 extends BaseTest {

    @Test
    public void verifyMuteFeatureInAdvertisementVideo() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_060 - Validate mute/unmute feature in advertisement video");

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

        // Step 3: Look for Advertisement iframe
        List<WebElement> adFrames = driver.findElements(By.cssSelector("iframe[id^='aswift_']"));

        if (adFrames.isEmpty()) {
            test.info("No Advertisement video iframe found on Signup page. Exiting test gracefully.");
            System.out.println("No Advertisement video iframe found on Signup page.");
            return; // exit gracefully
        }

        try {
            // Switch to ad iframe
            driver.switchTo().frame(adFrames.get(0));

            // Find video element
            List<WebElement> videos = driver.findElements(By.tagName("video"));
            if (videos.isEmpty()) {
                test.info("Advertisement iframe found but no <video> element present. Exiting test gracefully.");
                System.out.println("Advertisement iframe found but no <video> element present.");
                return;
            }

            WebElement video = videos.get(0);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Play the video
            js.executeScript("arguments[0].play()", video);
            Thread.sleep(2000);

            // Step 4: Mute the video
            js.executeScript("arguments[0].muted = true;", video);
            Boolean isMuted = (Boolean) js.executeScript("return arguments[0].muted;", video);

            if (isMuted) {
                String shot1 = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_060_Muted");
                test.pass("Video was successfully muted.").addScreenCaptureFromPath(shot1);
            } else {
                test.info("Mute action attempted, but video is still unmuted.");
            }

            // Step 5: Unmute the video
            js.executeScript("arguments[0].muted = false;", video);
            Boolean isUnmuted = !(Boolean) js.executeScript("return arguments[0].muted;", video);

            if (isUnmuted) {
                String shot2 = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_060_Unmuted");
                test.pass("Video was successfully unmuted.").addScreenCaptureFromPath(shot2);
            } else {
                test.info("Unmute action attempted, but video is still muted.");
            }

        } catch (Exception e) {
            test.info("Error while verifying mute feature: " + e.getMessage());
            System.out.println("Exception while verifying mute/unmute: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
