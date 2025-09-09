package Impact_Regression_TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Regres_Impact_05 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifyValidEmailForLogin() {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_05 - Verify Valid Email Address for Login");

        // Launch the URL
        driver.get("https://automationexercise.com/login");

        // Hardcoded valid credentials for login
        String validEmail = "peddamallu@gmail.com";  
        String validPassword = "Peddamallu@25";               

        // Locate the email textbox and enter a valid email
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailInput.sendKeys(validEmail);

        // Locate the password textbox and enter the password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordInput.sendKeys(validPassword);

        // Locate the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        // Verify successful login by checking "Logged in as" element
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInText.isDisplayed(), "Login failed! 'Logged in as' element not found.");

        // Log success in extent report
        test.pass("Successfully logged in using valid Email: " + validEmail);
    }
}
