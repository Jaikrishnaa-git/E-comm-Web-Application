package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_022_VerifyBrandMADAMEButton extends BaseTest {

    @Test
    public void verifyBrandMADAMEButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand MADAME button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By madameButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'MADAME')]");

            WebElement madameBtnElement = driver.findElement(madameButton);

            if (madameBtnElement.isDisplayed()) {
                test.pass("Brand MADAME button is visible");
            } else {
                test.fail("Brand MADAME button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_022"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_022"));
        }
    }
}
