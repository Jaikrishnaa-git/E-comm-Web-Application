package ContactUsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_ECOM_Contact_us_15 extends BaseTest {

    @Test
    public void verifyFeedbackLinkInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_15 - Verify Feedback link in Contact Us Page");

        // Locate the feedback link
        WebElement feedbackLink = driver.findElement(By.xpath("//a[contains(@href,'mailto:feedback@automationexercise.com')]"));

        // Verify displayed
        if (feedbackLink.isDisplayed()) {
            String hrefValue = feedbackLink.getAttribute("href");
            if (hrefValue.contains("feedback@automationexercise.com")) {
                test.pass("Feedback link is displayed and contains correct email.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_15"));
            } else {
                test.fail("Feedback link email is incorrect. Found: " + hrefValue)
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_15"));
                Assert.fail("Feedback link email is incorrect. Found: " + hrefValue);
            }
        } else {
            test.fail("Feedback link is not displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_15"));
            Assert.fail("Feedback link is not displayed");
        }
    }
}
