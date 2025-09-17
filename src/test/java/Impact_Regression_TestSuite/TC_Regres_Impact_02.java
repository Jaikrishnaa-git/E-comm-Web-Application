package Impact_Regression_TestSuite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ExcelUtilities;
import com.Ecomm.utilities.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Regres_Impact_02 extends BaseTest{

   
    static String projectPath = System.getProperty("user.dir");
  
    String excelPath =  projectPath + "\\src\\test\\resources\\Testdata\\data.xlsx";

    @DataProvider(name = "NameData")
    public Object[][] getNameData() throws IOException {
        return ExcelUtilities.getdata(excelPath, "Sheet2");
    }

    @Test(dataProvider = "NameData")
    public void verifyNameTextBox(String name, String email) {
        try {
            test.info("Opening signup/login page...");
            driver.get("https://www.automationexercise.com/login");

            // Locate the name input box
            WebElement nameTextbox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));

            // Clear and enter name
            nameTextbox.clear();
            nameTextbox.sendKeys(name);
            test.info("Entered name: " + name);

            // Validate if the name is correctly entered
            String enteredValue = nameTextbox.getAttribute("value");
            Assert.assertEquals(enteredValue, name, "Name is not entered correctly!");

            test.pass(" Successfully entered name: " + name);
            System.out.println("Name entered successfully: " + name);

        } catch (Exception e) {
            test.fail(" Test failed for name: " + name + " | Reason: " + e.getMessage());
            Assert.fail("Test failed for name: " + name, e);
        }
    }

}
