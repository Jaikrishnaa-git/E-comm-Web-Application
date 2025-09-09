package UiHomePage;

import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_Home_010_VerifyCategoryButtons extends BaseTest {

    @Test
    public void verifyCategoryButtons() throws IOException, InterruptedException {
        ExtentTest test = extent.createTest("Verify Women, Men, Kids Buttons in Category Section");

        HomePage home = new HomePage(driver);
        home.open();
        test.info("Navigated to home page");

        try {
            By womenBtn = By.xpath("//a[contains(text(),'Women')]");
            By menBtn = By.xpath("//a[contains(text(),'Men')]");
            By kidsBtn = By.xpath("//a[contains(text(),'Kids')]");

            boolean womenVisible = driver.findElement(womenBtn).isDisplayed();
            boolean menVisible = driver.findElement(menBtn).isDisplayed();
            boolean kidsVisible = driver.findElement(kidsBtn).isDisplayed();

            if (womenVisible && menVisible && kidsVisible) {
                test.pass("Women, Men, Kids buttons are visible");
            } else {
                test.fail("One or more category buttons are missing")
                    .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_010"));
            }

        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_Home_010"));
        }
    }
}
