package Subscription;

import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
        driver.get("https://automationexercise.com/");
        ExtentTest test = extent.createTest("Verify Subscription with email: " + email);

        HomePage home = new HomePage(driver);

        System.out.println("Testing with email: " + email);

        home.enterSubsciptionMail(email);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isSubmitted = false;
        try {
            isSubmitted = wait.until(driver -> home.isSubSubmittedDisplayed());
        } catch (Exception e) {
            isSubmitted = false;
        }

        System.out.println("Subscription success message displayed: " + isSubmitted);

        if (!isSubmitted) {
            test.pass("Subscription with invalid email was correctly not allowed.");
        } else {
            String screenshotPath = ScreenshotUtilities.capturescreen(
                    driver, "TC_ECOM_subHome_002_" + email.replaceAll("[^a-zA-Z0-9]", "_"));
            test.fail("Subscription with invalid email was incorrectly allowed!")
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @DataProvider
    public Object[][] homePageData() {
        try {
            System.out.println(">>> Loading data from Excel...");
            Object[][] data = ExcelUtilities.getdata(
                    projectPath + "\\src\\test\\resources\\Testdata\\Subscription data.xlsx",
                    "invalid email"
            );
            System.out.println(">>> Data loaded: " + data.length + " rows");
            return data;
        } catch (Exception e) {
            System.out.println(">>> ERROR reading Excel: " + e.getMessage());
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
