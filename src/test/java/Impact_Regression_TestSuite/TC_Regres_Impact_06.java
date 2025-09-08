package Impact_Regression_TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Regres_Impact_06 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifyValidPasswordForLogin() {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_06 - Verify Valid Password for Login");

        // Launch the URL
        driver.get("https://automationexercise.com/login");

        // Hardcoded valid credentials for login
        String validEmail = "peddamallu@gmail.com";  
        String validPassword = "Peddamallu@25";                 

        // Locate the email textbox and enter the valid email
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailInput.sendKeys(validEmail);

        // Locate the password textbox and enter the valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordInput.sendKeys(validPassword);

        // Locate and click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        // Verify successful login by checking "Logged in as" text
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInText.isDisplayed(), "Login failed! The 'Logged in as' element was not found.");

        // Log success in Extent Reports
        test.pass("Successfully logged in using valid password: " + validPassword);
    }
}
