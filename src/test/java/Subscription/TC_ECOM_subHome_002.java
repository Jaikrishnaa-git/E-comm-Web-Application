package Subscription;

import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.HomePage;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;

public class TC_ECOM_subHome_002 extends BaseTest {
    static String projectPath = System.getProperty("user.dir");

    @Test(dataProvider = "homePageData")
    public void verifySubscription(String email, String dummy) throws IOException, InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Verify Subscription with email: " + email);

        HomePage home = new HomePage(driver);
        home.enterSubsciptionMail(email);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isSubmitted = false;
        try {
            isSubmitted = wait.until(driver -> home.isSubSubmittedDisplayed());
        } catch (Exception e) {
            isSubmitted = false;
        }

        if (!isSubmitted) {
            test.pass("Subscription with invalid email was correctly not allowed.");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(
                    driver, "TC_ECOM_subHome_002_" + email.replaceAll("[^a-zA-Z0-9]", "_"));
            test.fail("Subscription with invalid email was incorrectly allowed!")
                .addScreenCaptureFromPath(screenshotPath);
            softAssert.fail("Subscription incorrectly allowed for email: " + email);
        }

        softAssert.assertAll(); // Report all soft assertion failures for this iteration
    }

    @DataProvider
    public Object[][] homePageData() {
        try {
            Object[][] data = ExcelUtilities.getdata(
                    projectPath + "\\src\\test\\resources\\Testdata\\Subscription data.xlsx",
                    "invalid email"
            );
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
