package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_021_VerifyBrandHMButton extends BaseTest {

    @Test
    public void verifyBrandHMButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand H&M button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By hmButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'H&M')]");

            WebElement hmBtnElement = driver.findElement(hmButton);

            if (hmBtnElement.isDisplayed()) {
                test.pass("Brand H&M button is visible");
            } else {
                test.fail("Brand H&M button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_021"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_021"));
        }
    }
}
