package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_020_VerifyBrandBIBAButton extends BaseTest {

    @Test
    public void verifyBrandBIBAButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand BIBA button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By bibaButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'BIBA')]");

            WebElement bibaBtnElement = driver.findElement(bibaButton);

            if (bibaBtnElement.isDisplayed()) {
                test.pass("Brand BIBA button is visible");
            } else {
                test.fail("Brand BIBA button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_020"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_020"));
        }
    }
}
