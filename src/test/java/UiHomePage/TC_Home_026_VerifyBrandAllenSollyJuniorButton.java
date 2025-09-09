package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_026_VerifyBrandAllenSollyJuniorButton extends BaseTest {

    @Test
    public void verifyBrandAllenSollyJuniorButton() throws IOException {
        ExtentTest test = extent.createTest("Verify Brand ALLEN SOLLY JUNIOR button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By allenSollyJuniorButton = By.xpath("//div[@class='brands-name']//a[contains(text(),'ALLEN SOLLY JUNIOR')]");

            WebElement allenSollyBtnElement = driver.findElement(allenSollyJuniorButton);

            if (allenSollyBtnElement.isDisplayed()) {
                test.pass("Brand ALLEN SOLLY JUNIOR button is visible");
            } else {
                test.fail("Brand ALLEN SOLLY JUNIOR button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_026"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_026"));
        }
    }
}
