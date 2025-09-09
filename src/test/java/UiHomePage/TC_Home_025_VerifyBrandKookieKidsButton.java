package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_025_VerifyBrandKookieKidsButton extends BaseTest {

    @Test
    public void verifyBrandKookieKidsButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand KOOKIE KIDS button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By kookieKidsButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'KOOKIE KIDS')]");

            WebElement kookieKidsBtnElement = driver.findElement(kookieKidsButton);

            if (kookieKidsBtnElement.isDisplayed()) {
                test.pass("Brand KOOKIE KIDS button is visible");
            } else {
                test.fail("Brand KOOKIE KIDS button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_025"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_025"));
        }
    }
}
