package UiTestcasePage;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Ecommerce_Web_Application_testcase_01_2_3_4_5_6_7_8	 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void TC_Ecommerce_Web_Application_testcase_01() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_01 - Verify Home Page");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        if (home.isHomePageVisible()) {
            test.pass("Home Page loaded successfully");
        } else {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC01_Fail");
            test.fail("Home Page not visible").addScreenCaptureFromPath(shot);
            softAssert.fail("Home Page not visible");
        }
        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_02() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_02 - Verify Products Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickProducts();
        softAssert.assertTrue(driver.getCurrentUrl().contains("products"), "Products page not opened");
        test.pass("Products button working correctly");
        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_03() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_03 - Verify Cart Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickCart();
        softAssert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page not opened");
        test.pass("Cart button working correctly");
        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_04() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_04 - Verify Signup/Login Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickSignupLogin();
        softAssert.assertTrue(driver.getCurrentUrl().contains("login"), "Signup/Login page not opened");
        test.pass("Signup/Login button working correctly");
        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_05() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_05 - Verify Test Cases Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickTestCases();
        softAssert.assertTrue(driver.getCurrentUrl().contains("test_cases"), "Test Cases page not opened");
        test.pass("Test Cases button working correctly");
        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_06() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_06 - Verify API Testing Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickApiTesting();
        softAssert.assertTrue(driver.getTitle().toLowerCase().contains("api"), "API Testing page not opened");
        test.pass("API Testing button working correctly");
        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_07() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_07 - Verify Video Tutorials Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickVideoTutorials();

        String currentUrl = driver.getCurrentUrl();
        // ✅ Fix: Video Tutorials redirects to YouTube
        softAssert.assertTrue(currentUrl.contains("youtube"), 
                "Video Tutorials page not opened, URL: " + currentUrl);
        test.pass("Video Tutorials button working correctly, redirected to: " + currentUrl);

        softAssert.assertAll();
    }

    @Test
    public void TC_Ecommerce_Web_Application_testcase_08() throws IOException {
        test = extent.createTest("TC_Ecommerce_Web_Application_testcase_08 - Verify Contact Us Button");
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        home.open();
        home.clickContactUs();
        softAssert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Contact Us page not opened");
        test.pass("Contact Us button working correctly");
        softAssert.assertAll();
    }
}
