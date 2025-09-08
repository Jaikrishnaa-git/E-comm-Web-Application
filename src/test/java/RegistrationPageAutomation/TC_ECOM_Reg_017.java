package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_017 extends BaseTest {

    @Test
    public void verifyNameTextboxWithValidName() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_017 - Verify Name Text Box with Valid Name");

        // Step 1: Open Automation Exercise website
        driver.get("https://www.automationexercise.com/");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on 'Signup / Login' button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Signup / Login')]")));
        signupLoginBtn.click();
        test.info("Clicked on Signup/Login button.");

        // Step 3: Enter valid Name and unique Email
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']")));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        String validName = "Jaikrishna";
        String uniqueEmail = "Jaikrishna" + System.currentTimeMillis() + "@gmail.com";

        nameInput.clear();
        emailInput.clear();
        nameInput.sendKeys(validName);
        emailInput.sendKeys(uniqueEmail);
        test.info("Entered Name: " + validName + " and Email: " + uniqueEmail);

        // Step 4: Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
        test.info("Clicked on Signup button.");

        // Step 5: Verify navigation to 'Enter Account Information' page
        WebElement enterAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[contains(text(),'Enter Account Information')]")));
        Assert.assertTrue(enterAccountInfo.isDisplayed(),
                "Failed to navigate to Enter Account Information page");
        test.pass("Successfully navigated to Enter Account Information page.");

        // Step 6: Verify Name textbox contains correct value
        WebElement nameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        String actualNameValue = nameTextbox.getAttribute("value");
        Assert.assertEquals(actualNameValue, validName,
                "Name text box does not contain the expected value");
        test.pass("PASS - Name text box contains the correct value: " + actualNameValue);
    }
}
