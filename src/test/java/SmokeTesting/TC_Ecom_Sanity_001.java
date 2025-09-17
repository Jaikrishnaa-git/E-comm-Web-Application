package SmokeTesting;

import com.Ecomm.base.CrossBrowserBaseTest;
import com.Ecomm.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_Ecom_Sanity_001 extends CrossBrowserBaseTest {

	@Test(groups = {"smoke"})
    @Parameters("browser")
    public void verifyOpenUrlInDifferentBrowsers(String browser) {
        test = extent.createTest("TC_Ecom_Sanity_001 - Verify Open URL on " + browser);

        try {
            
            HomePage home = new HomePage(driver);
            home.open();
            test.info("Step 1: Opened the URL in " + browser);

            Assert.assertTrue(home.isHomePageVisible(), "❌ Home Page is NOT visible in " + browser);
            test.pass("Step 2: ✅ Home Page loaded successfully in " + browser);

            test.pass("🎉 Test Passed on " + browser);

        } catch (Exception e) {
            test.fail("❌ Test failed on " + browser + " due to exception: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
