package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_020 extends BaseTest {

    @Test
    public void verifyPasswordTextboxWithNoPassword() {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_020 - Verify Password Textbox Without Password");

        try {
            // Step 1: Open Automation Exercise website
            driver.get("https://www.automationexercise.com/");
            test.info("Opened Automation Exercise website.");

            // Step 2: Click on 'Signup / Login' button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Signup / Login')]")));
            signupLoginBtn.click();
            test.info("Clicked on Signup/Login button.");

            // Step 3: Enter Name and unique Email
            WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@data-qa='signup-name']")));
            WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

            String name = "Jai Krishn";
            String uniqueEmail = "jaikrishna" + System.currentTimeMillis() + "@gmail.com";

            nameInput.clear();
            emailInput.clear();
            nameInput.sendKeys(name);
            emailInput.sendKeys(uniqueEmail);
            test.info("Entered Name: " + name + " and Email: " + uniqueEmail);

            // Step 4: Click 'Signup' button
            WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signupButton.click();
            test.info("Clicked on Signup button.");

            // Step 5: Wait for 'Enter Account Information' page
            WebElement enterAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'Enter Account Information')]")));
            Assert.assertTrue(enterAccountInfo.isDisplayed(),
                    "Failed to navigate to Enter Account Information page");
            test.pass("Successfully navigated to Enter Account Information page.");

            // Step 6: Fill other details but leave Password empty
            driver.findElement(By.id("id_gender1")).click();

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear(); // Leave password empty

            driver.findElement(By.id("days")).sendKeys("16");
            driver.findElement(By.id("months")).sendKeys("October");
            driver.findElement(By.id("years")).sendKeys("2008");

            driver.findElement(By.id("first_name")).sendKeys("Jai");
            driver.findElement(By.id("last_name")).sendKeys("Krishna");
            driver.findElement(By.id("company")).sendKeys("REVA UNIVERSITY");
            driver.findElement(By.id("address1")).sendKeys("Rukmini knowledge park, kattigenahalli");
            driver.findElement(By.id("address2")).sendKeys("Rukmini knowledge park, kattigenahalli");
            driver.findElement(By.id("country")).sendKeys("India");
            driver.findElement(By.id("state")).sendKeys("Karnataka");
            driver.findElement(By.id("city")).sendKeys("Bangalore");
            driver.findElement(By.id("zipcode")).sendKeys("560064");
            driver.findElement(By.id("mobile_number")).sendKeys("8247473923");

            // Step 7: Click 'Create Account' without password
            WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
            createAccountBtn.click();
            test.info("Clicked on Create Account button without entering password.");

            // Step 8: Verify validation message
            String validationMessage = passwordField.getAttribute("validationMessage");
            test.info("Validation Message: " + validationMessage);

            Assert.assertEquals(validationMessage, "Please fill out this field.",
                    "Validation message mismatch!");
            test.pass("PASS - Correct password validation message displayed: " + validationMessage);

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
