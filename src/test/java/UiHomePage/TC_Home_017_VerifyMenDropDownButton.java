package UiHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_017_VerifyMenDropDownButton extends BaseTest {

    @Test
    public void verifyMenDropDown() throws IOException {
        ExtentTest test = extent.createTest("Verify Men dropdown button on homepage");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to homepage");

        try {
            By menDropdown = By.xpath("//div[@class='left-sidebar']//a[contains(text(),'Men')]");

            WebElement menDropdownElement = driver.findElement(menDropdown);

            if (menDropdownElement.isDisplayed()) {
                test.pass("Men dropdown button is visible");
            } else {
                test.fail("Men dropdown button is NOT visible")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_017"));
            }
        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_017"));
        }
    }
}
