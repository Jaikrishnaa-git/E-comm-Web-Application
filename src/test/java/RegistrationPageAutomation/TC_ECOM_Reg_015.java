package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_015 extends BaseTest {

    @Test
    public void verifyMrRadioButtonInSignupPage() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_015 - Verify Mr Radio Button in Signup Page");

        try {
            // Step 1: Open Automation Exercise website
            driver.get("https://www.automationexercise.com/");
            test.info("Opened Automation Exercise website.");

            // Step 2: Click on Signup/Login button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement signupLoginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Signup / Login')]")));
            signupLoginBtn.click();
            test.info("Clicked on Signup/Login button.");

            // Step 3: Enter Name and Unique Email
            WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@data-qa='signup-name']")));
            WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

            String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
            nameInput.clear();
            emailInput.clear();
            nameInput.sendKeys("Vinod Reddy");
            emailInput.sendKeys(uniqueEmail);
            test.info("Entered user details with unique email: " + uniqueEmail);

            // Step 4: Click Signup button
            WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
            signupButton.click();
            test.info("Clicked on Signup button.");

            // Step 5: Verify navigation to Enter Account Information page
            WebElement enterAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'Enter Account Information')]")));
            Assert.assertTrue(enterAccountInfo.isDisplayed(),
                    "Failed to navigate to Enter Account Information page");
            test.pass("User successfully navigated to Enter Account Information page.");

            // Step 6: Verify and click Mr radio button
            WebElement mrRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
            mrRadioButton.click();
            Assert.assertTrue(mrRadioButton.isSelected(), "Mr radio button is not selected");
            test.pass("PASS - Mr radio button is successfully clicked.");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
