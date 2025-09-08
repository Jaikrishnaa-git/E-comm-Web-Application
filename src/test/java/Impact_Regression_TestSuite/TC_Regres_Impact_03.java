package Impact_Regression_TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Regres_Impact_03 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifyEmailTextBox() {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_03 - Verify Email Text Box");

        // Launch the URL
        driver.get("https://www.automationexercise.com/login");

        // Hardcoded email data for this test case
        String email = "JaiKrishnaa.git@gmail.com";

        // Locate the email textbox and enter the value
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailInput.sendKeys(email);

        // Verify that the entered email is correct
        String enteredEmail = emailInput.getAttribute("value");
        Assert.assertEquals(enteredEmail, email, "Email textbox did not accept the expected value!");

        // Log success in extent report
        test.pass("Successfully entered email: " + email + " in the signup email textbox.");
    }
}
