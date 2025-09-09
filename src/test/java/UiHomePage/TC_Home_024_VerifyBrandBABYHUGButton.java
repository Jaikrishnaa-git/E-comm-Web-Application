package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_024_VerifyBrandBABYHUGButton extends BaseTest {

    @Test
    public void verifyBrandBABYHUGButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand BABYHUG button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By babyhugButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'BABYHUG')]");

            WebElement babyhugBtnElement = driver.findElement(babyhugButton);

            if (babyhugBtnElement.isDisplayed()) {
                test.pass("Brand BABYHUG button is visible");
            } else {
                test.fail("Brand BABYHUG button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_024"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_024"));
        }
    }
}
