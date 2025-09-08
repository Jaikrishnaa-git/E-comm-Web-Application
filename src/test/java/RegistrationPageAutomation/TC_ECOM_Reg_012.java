package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_012 extends BaseTest {

    @Test
    public void verifySignupWithNoNameAndEmail() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_012 - Verify Signup with No Name & Email");

        // Step 1: Open Automation Exercise website
        driver.get("https://www.automationexercise.com");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on Signup/Login button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Signup / Login')]")));
        signupLoginBtn.click();
        test.info("Clicked on Signup/Login button.");

        // Step 3: Locate Name and Email input fields
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-name']")));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        // Step 4: Leave fields blank
        nameInput.clear();
        emailInput.clear();
        test.info("Left Name and Email fields blank.");

        // Step 5: Click Signup button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
        test.info("Clicked on Signup button.");

        Thread.sleep(2000); // Optional: wait to see browser validation

        // Step 6: Verify browser validation message or redirection
        String nameValidationMsg = nameInput.getAttribute("validationMessage");
        if (nameValidationMsg != null && !nameValidationMsg.isEmpty()) {
            test.pass("PASS - Browser displayed validation message: " + nameValidationMsg);
            Assert.assertTrue(true, "Validation message displayed as expected.");
        } else {
            String currentUrl = driver.getCurrentUrl().replace("www.", "");
            String expectedUrl = "https://automationexercise.com/login";
            Assert.assertEquals(currentUrl, expectedUrl,
                    "FAIL - User got redirected to registration page with empty details!");
            test.pass("PASS - User is NOT able to register with empty name and email.");
        }
    }
}
