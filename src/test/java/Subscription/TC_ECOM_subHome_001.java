package Subscription;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;

public class TC_ECOM_subHome_001 extends BaseTest {
    static String projectpath = System.getProperty("user.dir");

    @Test(dataProvider = "homePageData")
    public void verifySubsscription(String email, String dummy) throws IOException, InterruptedException {
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Verify Subscription email box");
        HomePage home = new HomePage(driver);

        System.out.println(email);
        Thread.sleep(3000);
        home.enterSubsciptionMail(email);

        if (home.isSubSubmittedDisplayed()) {
            test.pass("Subscribed using valid email");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TC_ECOM_subHome_001");
            test.fail("Unable to subscribe with valid mail").addScreenCaptureFromPath(screenshotPath);
            Assert.fail("Unable to subscribe with valid mail");
        }
    }

    @DataProvider
    public Object[][] homePageData() {
        try {
            Object[][] data = ExcelUtilities.getdata(
                    projectpath + "\\src\\test\\resources\\Testdata\\Subscription data.xlsx", "valid email");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
