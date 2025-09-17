package SmokeTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.LoginPage;

public class TC_Ecom_Sanity_005 extends BaseTest {

	@Test(groups = {"smoke"})
    public void verifySignupAndLoginForms() {
        test = extent.createTest("TC_Ecom_Sanity_005 - Verify Signup & Login Forms");

        try {
            // Step 1: Open the URL
            driver.get("https://www.automationexercise.com/");
            test.info("Step 1: Opened the URL in browser");

            // Step 2: Click on Signup/Login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openLoginPage();
            test.info("Step 2: Clicked on Signup/Login");

            // Step 3: Verify forms are displayed
            Assert.assertTrue(loginPage.isLoginFormVisible(), "❌ Login form is NOT displayed");
            test.pass("Step 3: ✅ Login form displayed");

            Assert.assertTrue(loginPage.isSignupFormVisible(), "❌ Signup form is NOT displayed");
            test.pass("Step 3: ✅ Signup form displayed");

            // Step 4: Analyze Result
            test.pass("Step 4: 🎉 Both Login and Signup forms are visible. Test Passed.");

        } catch (Exception e) {
            test.fail("❌ Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
