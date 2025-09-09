package UiHomePage;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.aventstack.extentreports.ExtentTest;

public class TC_Home_028_VerifyHomePageLoadsOnChrome extends BaseTest {

    @Test
    public void verifyHomePageLoadsOnChrome() {
        ExtentTest test = extent.createTest("Verify Home Page loads on Chrome");

        HomePage home = new HomePage(driver);
        home.open();

        if (home.isHomePageVisible()) {
            test.pass("Home page loaded successfully on Chrome.");
        } else {
            test.fail("Home page did NOT load successfully on Chrome.");
        }
    }
}
