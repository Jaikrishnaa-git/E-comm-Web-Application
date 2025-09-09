package UiHomePage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_011_VerifyBrandsButtons extends BaseTest {

    @Test
    public void verifyBrandsButtons() throws IOException {
        ExtentTest test = extent.createTest("Verify all buttons in Brands section on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By brandsSection = By.cssSelector(".brands-name a");
            List<WebElement> brandButtons = driver.findElements(brandsSection);

            if (brandButtons.size() > 0) {
                boolean allDisplayed = true;
                for (WebElement btn : brandButtons) {
                    if (!btn.isDisplayed()) {
                        allDisplayed = false;
                        break;
                    }
                }
                if (allDisplayed) {
                    test.pass("All brand buttons are displayed");
                } else {
                    test.fail("Some brand buttons are not visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_011"));
                }
            } else {
                test.fail("No brand buttons found on homepage")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_011"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_011"));
        }
    }
}
