package UiTestcasePage;

import com.Ecomm.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TC_Ecommerce_Web_Application_Testcase_11_12_13 {

    String url = "https://automationexercise.com/testcases";
    WebDriver driver;
    static ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setupReport() {
        extent = ExtentManager.createInstance("TC_Ecommerce_Web_Application_Testcase_11_12_13");
    }

    @Test(groups = { "UI_Testing" })
    public void verifyTestcasePageOnChrome() {
        test = extent.createTest("Testcase 11 - Chrome");
        try {
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            test.pass("✅ Chrome: Website opened successfully");
        } catch (Exception e) {
            test.fail("❌ Exception in Chrome test: " + e.getMessage());
        } finally {
            if (driver != null) driver.quit();
        }
    }

    @Test
    public void verifyTestcasePageOnEdge() {
        test = extent.createTest("Testcase 12 - Edge");
        try {
            driver = new EdgeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            test.pass("✅ Edge: Website opened successfully");
        } catch (Exception e) {
            test.fail("❌ Exception in Edge test: " + e.getMessage());
        } finally {
            if (driver != null) driver.quit();
        }
    }

    @Test
    public void verifyTestcasePageOnFirefox() {
        test = extent.createTest("Testcase 13 - Firefox");
        try {
            driver = new FirefoxDriver();
            driver.get(url);
            driver.manage().window().maximize();
            test.pass("✅ Firefox: Website opened successfully");
        } catch (Exception e) {
            test.fail("❌ Exception in Firefox test: " + e.getMessage());
        } finally {
            if (driver != null) driver.quit();
        }
    }

    @AfterClass
    public void flushReport() {
        extent.flush();
    }
}
