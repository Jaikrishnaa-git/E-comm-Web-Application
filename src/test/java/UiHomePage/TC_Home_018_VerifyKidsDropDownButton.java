package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_018_VerifyKidsDropDownButton extends BaseTest {

    @Test
    public void verifyKidsDropDown() throws IOException {
        ExtentTest test = extent.createTest("Verify Kids dropdown button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By kidsDropdown = By.xpath("//div[@class='left-sidebar']//a[contains(text(),'Kids')]");

            WebElement kidsDropdownElement = driver.findElement(kidsDropdown);

            if (kidsDropdownElement.isDisplayed()) {
                test.pass("Kids dropdown button is visible");
            } else {
                test.fail("Kids dropdown button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_018"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_018"));
        }
    }
}
