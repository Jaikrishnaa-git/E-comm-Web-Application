package Corebusiness;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.LoginPage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_regr_core_002 extends BaseTest {
    static String projectPath = System.getProperty("user.dir");

    @Test(dataProvider = "logindata", groups = {"regression", "login"})
    public void f(String email, String password) throws InterruptedException, IOException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Login Test with Email: " + email);

        LoginPage login = new LoginPage(driver);
        login.openLoginPage();
        login.loginCredentials(email, password);

        if (!login.logoutDisplayed()) {
            test.pass("Login with invalid credentials failed as expected");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(
                    driver, "TC_regr_core_002_" + email.replaceAll("[^a-zA-Z0-9]", "_"));
            test.fail("Logged in with invalid credentials")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Invalid credentials accepted for email: " + email);
        }

        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] logindata() {
        try {
            Object[][] data = ExcelUtilities.getdata(
                    projectPath + "\\src\\test\\resources\\Testdata\\data.xlsx",
                    "Login invalid Credentials");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
