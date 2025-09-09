package UiHomePage;

import com.Ecomm.base.CrossBrowserBaseTest;
import com.Ecomm.pages.HomePage;
import org.testng.annotations.Test;

public class TC_Home_029_verify_HomePage_Egde extends CrossBrowserBaseTest {

    @Test
    public void verifyHomePageLoadsOnEdge() {
        test = extent.createTest("TC_ECOM_Home_029 - Verify Home Page Loads on Edge");

        HomePage homePage = new HomePage(driver);
        homePage.open();
        test.info("Opened homepage in Edge");

        if (homePage.isHomePageVisible()) {
            test.pass("Home page loaded successfully in Edge.");
        } else {
            test.fail("Home page did not load in Edge.");
        }
    }
}
