package UiHomePage;

import com.Ecomm.base.CrossBrowserBaseTest;
import com.Ecomm.pages.HomePage;
import org.testng.annotations.Test;

public class TC_Home_030__verify_HomePage_firefox extends CrossBrowserBaseTest {

    @Test
    public void verifyHomePageLoadsOnFirefox() {
        test = extent.createTest("TC_ECOM_Home_030 - Verify Home Page Loads on Firefox");

        HomePage homePage = new HomePage(driver);
        homePage.open();
        test.info("Opened homepage in Firefox");

        if (homePage.isHomePageVisible()) {
            test.pass("✅ Home page loaded successfully in Firefox.");
        } else {
            test.fail("❌ Home page did not load in Firefox.");
        }
    }
}
