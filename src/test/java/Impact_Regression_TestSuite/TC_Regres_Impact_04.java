package Impact_Regression_TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Regres_Impact_04 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifySignupFunctionality() {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_04 - Verify Signup Button with Name & Email");

        // Launch the URL
        driver.get("https://www.automationexercise.com/login");

        // Hardcoded test data for this case
        String name = "Jai Krishnaa";
        String email = "JaiKrishna98.git@gmail.com";

        // Locate and enter name
        WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameInput.sendKeys(name);

        // Locate and enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailInput.sendKeys(email);

        // Locate signup button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));

        // Verify the button is visible and enabled before clicking
        Assert.assertTrue(signupButton.isDisplayed(), "Signup button is not displayed!");
        Assert.assertTrue(signupButton.isEnabled(), "Signup button is not enabled!");

        // Click on the signup button
        signupButton.click();

        // Verify navigation to Enter Account Information page
        WebElement accountInfoHeader = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(accountInfoHeader.isDisplayed(), "Navigation to account info page failed after clicking signup!");

        // Log success in extent report
        test.pass("Successfully entered Name & Email, clicked signup button, and navigated to account information page.");
    }
}
