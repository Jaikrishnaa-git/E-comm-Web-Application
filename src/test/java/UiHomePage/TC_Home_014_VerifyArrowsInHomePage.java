package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_014_VerifyArrowsInHomePage extends BaseTest {

    @Test
    public void verifyArrows() throws IOException {
        ExtentTest test = extent.createTest("Verify Arrows presence on Homepage slider");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By leftArrowLocator = By.cssSelector(".left.control.carousel-control");
            By rightArrowLocator = By.cssSelector(".right.control.carousel-control");

            WebElement leftArrow = driver.findElement(leftArrowLocator);
            WebElement rightArrow = driver.findElement(rightArrowLocator);

            if (leftArrow.isDisplayed() && rightArrow.isDisplayed()) {
                test.pass("Left and Right arrows are visible on homepage slider");
            } else {
                test.fail("One or both arrows are not visible on homepage slider")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_014"));
            }
        } catch (Exception e) {
            test.fail("Exception: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_014"));
        }
    }
}
