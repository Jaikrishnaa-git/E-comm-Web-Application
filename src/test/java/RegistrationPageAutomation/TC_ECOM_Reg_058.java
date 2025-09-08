package RegistrationPageAutomation;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_ECOM_Reg_058 extends BaseTest {

    @Test
    public void verifyAdvertisementLinkOnSignupPage() throws IOException {
        test = extent.createTest("TC_ECOM_Reg_058 - Validate advertisement link on Signup page");

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

        // Step 3: Look for Advertisement on signup page
        List<WebElement> adFrames = driver.findElements(By.cssSelector("iframe[id^='aswift_']"));

        if (adFrames.isEmpty()) {
            test.info("No Advertisement found on Signup page.");
            System.out.println("No Advertisement found on Signup page.");
            return; // Exit test gracefully
        }

        String parentWindow = driver.getWindowHandle();

        try {
            // Switch to the first advertisement iframe
            driver.switchTo().frame(adFrames.get(0));

            // Find ad link and click it
            WebElement adLink = driver.findElement(By.tagName("a"));
            adLink.click();
            test.info("Clicked on the Advertisement link");

            // Switch to new tab/window
            for (String winHandle : driver.getWindowHandles()) {
                if (!winHandle.equals(parentWindow)) {
                    driver.switchTo().window(winHandle);
                    break;
                }
            }

            // Capture screenshot
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Reg_058");

            // Step 4: Verify redirect
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl != null && !currentUrl.isEmpty() && !currentUrl.contains("automationexercise")) {
                test.pass("PASS: User successfully redirected to advertised products page: " + currentUrl)
                    .addScreenCaptureFromPath(shot);
            } else {
                test.fail("FAIL: Advertisement did not redirect to a valid product page")
                    .addScreenCaptureFromPath(shot);
                Assert.fail("Advertisement click did not redirect properly.");
            }

        } catch (Exception e) {
            test.info("Advertisement frame found, but no clickable ad inside. Exception: " + e.getMessage());
            System.out.println("Advertisement present but not clickable.");
        } finally {
            // Switch back to parent window
            driver.switchTo().window(parentWindow);
        }
    }
}
