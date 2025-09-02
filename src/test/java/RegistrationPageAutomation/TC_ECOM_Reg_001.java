package RegistrationPageAutomation;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC_ECOM_Reg_001 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    ExtentReports extent;
    ExtentTest test;
    ExtentSparkReporter spark;

    @Test
    public void f() throws InterruptedException {
        test = extent.createTest("Checking browser in Registration page");
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        try {
	            driver.get("https://automationexercise.com/");
	            test.info("Navigated to automationexercise.com");
	            Thread.sleep(3000);
	            if(driver.getTitle().equals("Automation Exercise"))
	            {
	            	 test.pass("Registration Page loads on the "+browserName+"browser");
	            }
	            else
	            {
	            	test.fail("Registration Page does not loads on the "+browserName+"browser");
	            }
            }
        catch(Exception e)
        {
        		test.fail("Test encountered an exception: " + e.getMessage());
           
        }
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String brow) {
        System.out.println("Before Method started for browser: " + brow);

        try {
            switch (brow.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser name: " + brow);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            System.out.println(brow + " browser launched successfully.");

        } catch (Exception e) {
            System.err.println("Error launching browser: " + brow);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before Suite");
        spark = new ExtentSparkReporter(projectPath+"\\src\\test\\resources\\Reports\\TC_ECOM_Reg_001.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is After Suite");
        extent.flush();
    }
}
