package Subscription;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_subHome_001 extends BaseTest {
    static String projectPath = System.getProperty("user.dir");

    @Test(dataProvider = "subscriptionData")
    public void verifySubscription(String email, String type) throws IOException, InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Verify Subscription for: " + email + " (" + type + ")");
        HomePage home = new HomePage(driver);

        home.enterSubsciptionMail(email);

        if ("valid".equalsIgnoreCase(type)) {
            if (home.isSubSubmittedDisplayed()) {
                test.pass("Subscribed successfully with valid email: " + email);
            } else {
                String screenshot = ScreenshotUtilities.capturescreen(driver, "Subscription_Fail_" + email);
                test.fail("Unable to subscribe with valid email: " + email)
                    .addScreenCaptureFromPath(screenshot);
                softAssert.fail("Subscription failed for valid email: " + email);
            }
        } else if ("invalid".equalsIgnoreCase(type)) {
            if (!home.isSubSubmittedDisplayed()) {
                test.pass("Subscription correctly blocked for invalid email: " + email);
            } else {
                String screenshot = ScreenshotUtilities.capturescreen(driver, "Subscription_Invalid_Fail_" + email);
                test.fail("Subscribed with invalid email: " + email)
                    .addScreenCaptureFromPath(screenshot);
                softAssert.fail("Subscription succeeded with invalid email: " + email);
            }
        } else {
            softAssert.fail("Unknown email type provided in Excel: " + type);
        }

        softAssert.assertAll(); 
    }

    @DataProvider
    public Object[][] subscriptionData() {
        try {
            Object[][] data = ExcelUtilities.getdata(
                projectPath + "\\src\\test\\resources\\Testdata\\Subscription data.xlsx", "Sheet1");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
