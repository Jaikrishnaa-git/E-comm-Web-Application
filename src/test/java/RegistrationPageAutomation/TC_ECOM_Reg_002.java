package RegistrationPageAutomation;

import org.testng.annotations.Test;

import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ExtentManager;
import com.Ecomm.utilities.ScreenshotUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC_ECOM_Reg_002 {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
  @Test
  public void f() {
	  test = extent.createTest("Checking name feild in Registration page");
	  driver.get("https://automationexercise.com/");
	  SignupPage signup  = new SignupPage(driver);
	  signup.clickSignupLoginLink();
	  test.info("Navigated to automationexercise.com");
	  try
	  {
		 if(signup.nameIsdisplayed())
		 {
			 test.pass("The name feild is displayed");
		 }
		 else
		 {
			 test.fail("The name feild is not displayed");
			 ScreenshotUtilities.capturescreen(driver,"TC_ECOM_Reg_002" );
		 }
	  }
	  catch(Exception e)
	  {
		  test.fail("Name feild not found");
	  }
  }
  @Parameter
  @BeforeMethod
  public void beforeMethod(String brow) 
  {
	  switch(brow.toLowerCase())
	  {
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
	  }
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  extent = ExtentManager.getInstance();
  }

  @AfterSuite
  public void afterSuite() {
	  extent.flush();
  }

}
