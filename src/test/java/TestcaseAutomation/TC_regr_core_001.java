package TestcaseAutomation;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC_regr_core_001 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    ExtentReports extent;
    ExtentTest test;
    ExtentSparkReporter spark;

    @Test(dataProvider = "logindata")
    public void f(String username, String password) throws InterruptedException {
        test = extent.createTest("Login Test for user: " + username);

        try {
            driver.get("https://automationexercise.com/");
            test.info("Navigated to automationexercise.com");

            driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")).click();
            test.info("Clicked on Login button");

            WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));

            if (emailInput.isDisplayed() && passwordInput.isDisplayed()) {
                test.pass("Login page loaded successfully.");
            } else {
                test.fail("Login page not displayed correctly.");
                Assert.fail("Login page not displayed.");
            }

            emailInput.sendKeys(username);
            passwordInput.sendKeys(password);
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
            test.info("Submitted login form with credentials.");

            Thread.sleep(2000);
            boolean isLoggedIn = driver.findElements(By.xpath("//a[contains(text(),'Logout')]")).size() > 0;

            if (isLoggedIn) {
                test.pass("Login successful for user: " + username);
            } else {
                test.fail("Login failed for user: " + username);
                Assert.fail("Login failed - Logout link not found.");
            }

        } catch (Exception e) {
            test.fail("Test encountered an exception: " + e.getMessage());
            Assert.fail("Exception during test: " + e.getMessage());
        }
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String brow) {
        System.out.println("This is Before Method");

        if (brow.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        if (brow.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        if (brow.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        driver.quit();
    }

    @DataProvider
    public Object[][] logindata() throws IOException {
        File file = new File(projectPath + "\\TC001_Credentials.xlsx");
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        int rowcount = worksheet.getPhysicalNumberOfRows();
        String data[][] = new String[rowcount][2];
        System.out.println("rows:" + rowcount);
        for (int i = 0; i < rowcount; i++) {
            data[i][0] = worksheet.getRow(i).getCell(0).getStringCellValue();
            data[i][1] = worksheet.getRow(i).getCell(1).getStringCellValue();
        }
        workbook.close();
        fs.close();
        return data;
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
        spark = new ExtentSparkReporter(projectPath + "/test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is After Suite");
        extent.flush();
    }
}
