package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_014 extends BaseTest {

    @Test
    public void verifySignupWithExistingEmail() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_014 - Verify Signup with Existing Email");

        try {
            // Step 1: Open Automation Exercise website
            driver.get("https://www.automationexercise.com/");
            test.info("Opened Automation Exercise website.");

            // Step 2: Click on Signup/Login button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Signup / Login')]")));
            signupLoginBtn.click();
            test.info("Clicked on Signup/Login button.");

            // Step 3: Enter Name and Existing Email
            WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@data-qa='signup-name']")));
            WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

            nameInput.clear();
            emailInput.clear();
            nameInput.sendKeys("Jaikrishnaa");
            emailInput.sendKeys("Jaikrishnaa1.git@gmail.com");
            test.info("Entered existing user details.");

            // Step 4: Click Signup button
            WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signupButton.click();
            test.info("Clicked on Signup button.");

            // Step 5: Check for either account info page or error message
            try {
                WebElement accountInfoHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//b[contains(text(),'Enter Account Information')]")));

                if (accountInfoHeading.isDisplayed()) {
                    test.pass("PASS - User redirected to 'Enter Account Information' page successfully.");
                    Assert.assertTrue(true, "User redirected to Enter Account Information page.");
                    return;  
                }

            } catch (Exception e) {
                WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(),'Email Address already exists!')]")));

                String actualMsg = errorMsg.getText().trim();
                String expectedMsg = "Email Address already exists!";
                Assert.assertEquals(actualMsg, expectedMsg, "Error message did not match!");
                test.pass("PASS - Correct error message displayed: " + actualMsg);
            }

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
