package SmokeTesting;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Ecom_Sanity_002 extends BaseTest {

    @Test
    public void verifyNavigationLinks() throws IOException {
        test = extent.createTest("TC_Ecom_Sanity_002 - Verify Navigation Links");

        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        // Step 1: Open home page
        home.open();
        test.info("Opened Home Page");

        if (home.isHomePageVisible()) {
            test.pass("✅ Home Page loaded successfully");
        } else {
            test.fail("❌ Home page did not load properly");
            softAssert.fail("Home page did not load properly");
        }

        try {
            // 1. Cart
            home.clickCart();
            softAssert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart link failed");
            test.pass("✅ Cart link working correctly");
            driver.navigate().back();

            // 2. Signup / Login
            home.clickSignupLogin();
            softAssert.assertTrue(driver.getCurrentUrl().contains("login"), "Signup/Login link failed");
            test.pass("✅ Signup/Login link working correctly");
            driver.navigate().back();

            // 3. Test Cases
            home.clickTestCases();
            softAssert.assertTrue(driver.getCurrentUrl().contains("test_cases"), "Test Cases link failed");
            test.pass("✅ Test Cases link working correctly");
            driver.navigate().back();

            // 4. API Testing
            home.clickApiTesting();
            softAssert.assertTrue(driver.getTitle().toLowerCase().contains("api"), "API Testing link failed");
            test.pass("✅ API Testing link working correctly");
            driver.navigate().back();

            // 5. Products
            home.clickProducts();
            softAssert.assertTrue(driver.getCurrentUrl().contains("products"), "Products link failed");
            test.pass("✅ Products link working correctly");
            driver.navigate().back();

            // 6. Contact Us
            home.clickContactUs();
            softAssert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Contact Us link failed");
            test.pass("✅ Contact Us link working correctly");
            driver.navigate().back();

            test.pass("🎉 All navigation links verified successfully.");

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_Ecom_Sanity_002_Fail");
            test.fail("❌ Exception during navigation: " + e.getMessage())
                .addScreenCaptureFromPath(shot);
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Final assertion check
        softAssert.assertAll();
    }
}
