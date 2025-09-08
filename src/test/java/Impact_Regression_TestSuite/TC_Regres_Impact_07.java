package Impact_Regression_TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ExcelUtilities;

public class TC_Regres_Impact_07 extends BaseTest {

    // ✅ DataProvider using Data.xlsx (Sheet2)
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        String excelPath = System.getProperty("user.dir") 
                + "\\src\\test\\resources\\TestData\\Data.xlsx";  
        return ExcelUtilities.getdata(excelPath, "Sheet2");  // ✅ use Sheet2
    }

    @Test(dataProvider = "loginData")
    public void verifyLoginButton(String name, String email) {
        test = extent.createTest("TC_Regres_Impact_07 - Verify Login Button on Signup/Login page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/");
            test.info("Opened URL: https://automationexercise.com/");

            // Step 2: Click on Signup/Login button
            WebElement loginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            loginBtn.click();
            test.pass("Clicked on Signup/Login button");

            // Step 3: Enter Name & Email from Excel (Sheet2)
            WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
            WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

            nameInput.sendKeys(name);
            emailInput.sendKeys(email);
            test.pass("Entered Name: " + name + " and Email: " + email);

            // Step 4: Click Signup button
            WebElement signupBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signupBtn.click();
            test.pass("Clicked on Signup button");

            // ✅ Assertion: Check if redirected to signup form
            WebElement signupForm = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
            Assert.assertTrue(signupForm.isDisplayed(), "Signup form is not displayed!");
            test.pass("Signup/Login process verified successfully");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            test.info("Browser closed after execution");
        }
    }
}
