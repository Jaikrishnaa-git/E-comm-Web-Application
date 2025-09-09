package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_027_VerifyGoogleAdDropButton extends BaseTest {

    @Test
    public void verifyGoogleAdDropButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Google Ad drop button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By googleAdDropButton = By.xpath("//div[contains(@class,'google-ads')]//button[contains(text(),'Close')]");

            WebElement googleAdButton = driver.findElement(googleAdDropButton);

            if (googleAdButton.isDisplayed()) {
                test.pass("Google Ad drop button is visible");
            } else {
                test.fail("Google Ad drop button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_027"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred or Google Ad drop button not found: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_027"));
        }
    }
}
