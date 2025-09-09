package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_019_VerifyBrandPoloButton extends BaseTest {

    @Test
    public void verifyBrandPoloButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand Polo button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By poloButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'Polo')]");

            WebElement poloBtnElement = driver.findElement(poloButton);

            if (poloBtnElement.isDisplayed()) {
                test.pass("Brand Polo button is visible");
            } else {
                test.fail("Brand Polo button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_019"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_019"));
        }
    }
}
