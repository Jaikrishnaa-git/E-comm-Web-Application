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

public class TC_Home_013_VerifyViewProductButtonInFeaturedItems extends BaseTest {

    @Test
    public void verifyViewProductButton() throws IOException {
        ExtentTest test = extent.createTest("Verify View Product button in Featured Items");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By viewProductButtons = By.xpath("//div[@class='features_items']//a[contains(text(),'View Product')]");
            List<WebElement> buttons = driver.findElements(viewProductButtons);

            if (buttons.size() > 0) {
                boolean allDisplayed = true;
                for (WebElement btn : buttons) {
                    if (!btn.isDisplayed()) {
                        allDisplayed = false;
                        break;
                    }
                }
                if (allDisplayed) {
                    test.pass("All View Product buttons in Featured Items are visible");
                } else {
                    test.fail("Some View Product buttons in Featured Items are not visible")
                        .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_013"));
                }
            } else {
                test.fail("No View Product buttons found in Featured Items")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_013"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_013"));
        }
    }
}
