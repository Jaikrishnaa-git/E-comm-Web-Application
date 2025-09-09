package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_023_VerifyBrandMastAndHarbourButton extends BaseTest {

    @Test
    public void verifyBrandMastAndHarbourButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand MAST AND HARBOUR button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By mastAndHarbourButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'MAST AND HARBOUR')]");

            WebElement mastHarbourBtnElement = driver.findElement(mastAndHarbourButton);

            if (mastHarbourBtnElement.isDisplayed()) {
                test.pass("Brand MAST AND HARBOUR button is visible");
            } else {
                test.fail("Brand MAST AND HARBOUR button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_023"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_023"));
        }
    }
}
