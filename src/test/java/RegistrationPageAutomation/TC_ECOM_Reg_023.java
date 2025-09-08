package RegistrationPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_Reg_023 extends BaseTest {

    @Test
    public void verifyDateDropdownInSignup() {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_Reg_023: Verify and Validate Date Dropdown in Signup Page");

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

            String name = "Jai Krishna";
            String uniqueEmail = "jaikrishna.git+" + System.currentTimeMillis() + "@gmail.com";

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'Enter Account Information')]")));
            test.pass("Successfully navigated to Enter Account Information page.");

            // Step 6: Select gender
            driver.findElement(By.id("id_gender1")).click();

            // Step 7: Locate the date dropdowns
            WebElement dayDropdown = driver.findElement(By.id("days"));
            WebElement monthDropdown = driver.findElement(By.id("months"));
            WebElement yearDropdown = driver.findElement(By.id("years"));

            // Verify dropdowns are displayed
            Assert.assertTrue(dayDropdown.isDisplayed(), "Day dropdown is not visible!");
            Assert.assertTrue(monthDropdown.isDisplayed(), "Month dropdown is not visible!");
            Assert.assertTrue(yearDropdown.isDisplayed(), "Year dropdown is not visible!");
            test.info("Date dropdowns are displayed successfully.");

            // Step 8: Select values from dropdowns
            Select daySelect = new Select(dayDropdown);
            daySelect.selectByValue("16");

            Select monthSelect = new Select(monthDropdown);
            monthSelect.selectByVisibleText("October");

            Select yearSelect = new Select(yearDropdown);
            yearSelect.selectByValue("2008");

            test.info("Selected Date: 16 October 2008");

            // Step 9: Validate selected values
            Assert.assertEquals(daySelect.getFirstSelectedOption().getText(), "16", "Day selection failed!");
            Assert.assertEquals(monthSelect.getFirstSelectedOption().getText(), "October", "Month selection failed!");
            Assert.assertEquals(yearSelect.getFirstSelectedOption().getText(), "2008", "Year selection failed!");
            test.pass("User can select date from the drop-down successfully.");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
