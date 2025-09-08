package com.Ecomm.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.Ecomm.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setUp() {
<<<<<<< HEAD
        System.out.println("🚀 Launching Chrome...");
=======
        System.out.println("Launching Chrome...");
>>>>>>> 77bb121 (2025sep8 project)

        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize Extent Report
        String testClassName = this.getClass().getSimpleName();
        extent = ExtentManager.createInstance(testClassName);

<<<<<<< HEAD
        System.out.println("✅ Chrome launched successfully.");
=======
        System.out.println("Chrome launched successfully.");
>>>>>>> 77bb121 (2025sep8 project)
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
<<<<<<< HEAD
            System.out.println("🛑 Browser closed after all tests in this class.");
=======
            System.out.println("Browser closed after all tests in this class.");
>>>>>>> 77bb121 (2025sep8 project)
        }

        if (extent != null) {
            extent.flush();
<<<<<<< HEAD
            System.out.println("📊 Extent Report flushed.");
=======
            System.out.println("Extent Report flushed.");
>>>>>>> 77bb121 (2025sep8 project)
        }
    }
}