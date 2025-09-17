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

public class TC_ECOM_subHome_003 extends BaseTest {
    static String projectpath = System.getProperty("user.dir");

    @Test(dataProvider = "homePageData")
    public void verifySubscription(String email, String dummy) throws IOException, InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        email = "";

        ExtentTest test = extent.createTest("Verify Subscription without email: '" + email + "'");
        HomePage home = new HomePage(driver);

        System.out.println("Testing with email: " + email);
        Thread.sleep(3000);

        home.enterSubsciptionMail(email);

        if (!home.isSubSubmittedDisplayed()) {
            test.pass("Subscription without email was correctly not allowed.");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_subHome_003_" + (email.isEmpty() ? "empty" : email));
            test.fail("Subscribed with no email!").addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Subscription incorrectly allowed for empty email");
        }

        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] homePageData() {
        try {
            Object[][] data = ExcelUtilities.getdata(
                projectpath + "\\src\\test\\resources\\Testdata\\Subscription data.xlsx",
                "no email"
            );
            System.out.println(">>> Data loaded: " + data.length + " rows");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
