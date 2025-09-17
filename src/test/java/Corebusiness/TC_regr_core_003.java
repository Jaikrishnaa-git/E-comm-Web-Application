package Corebusiness;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.LoginPage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_003 extends BaseTest {
    static String projectPath = System.getProperty("user.dir");

    @Test(dataProvider = "logindata", groups = {"regression", "login"})
    public void logout(String email, String password) throws InterruptedException, IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Logout Test with Email: " + email);

        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.loginCredentials(email, password);
        login.logout();

        if (login.isSignupVisible()) {
            test.pass("Logout successful");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(
                    driver, "TC_regr_core_003_" + email.replaceAll("[^a-zA-Z0-9]", "_"));
            test.fail("Unable to logout")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Logout failed for email: " + email);
        }

        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] logindata() {
        try {
            Object[][] data = ExcelUtilities.getdata(
                    projectPath + "\\src\\test\\resources\\Testdata\\data.xlsx",
                    "Login valid Credentials");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
