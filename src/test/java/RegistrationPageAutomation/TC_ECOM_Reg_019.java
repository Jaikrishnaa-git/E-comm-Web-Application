package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_019 extends BaseTest {

    @Test
    public void verifyNameTextboxWithInvalidName() throws InterruptedException {

    
        test = extent.createTest("TC_ECOM_Reg_019 - Verify Name Text Box with Invalid Name");

        driver.get("https://www.automationexercise.com/");
        test.info("Opened Automation Exercise website.");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Signup / Login')]")));
        signupLoginBtn.click();
        test.info("Clicked on Signup/Login button.");

        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']")));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        String invalidName = "12345";
        String email = "preddyvinod2@gmail.com";

        nameInput.clear();
        emailInput.clear();
        nameInput.sendKeys(invalidName);
        emailInput.sendKeys(email);
        test.info("Entered INVALID Name: " + invalidName + " and Email: " + email);

  
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
        test.info("Clicked on Signup button.");


        boolean isEnterAccountInfoPage;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'Enter Account Information')]")));
            isEnterAccountInfoPage = true;
        } catch (Exception e) {
            isEnterAccountInfoPage = false;
        }

       
        Assert.assertFalse(isEnterAccountInfoPage,
                "User navigated to Enter Account Information page with invalid name!");

     
        WebElement errorMsg = null;
        try {
            errorMsg = driver.findElement(
                    By.xpath("//*[contains(text(),'Invalid name') or contains(text(),'valid name')]"));
        } catch (Exception e) {
        
        }

        if (errorMsg != null) {
            test.info("Error Message Displayed: " + errorMsg.getText());
            Assert.assertTrue(errorMsg.isDisplayed(), "Expected invalid name error message not displayed!");
            test.pass("PASS - Correct invalid name error message displayed: " + errorMsg.getText());
        } else {
            test.pass("PASS - User was not able to register with invalid name (no redirection).");
        }
    }
}