package SmokeTesting;

import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_Ecom_Sanity_010 extends BaseTest {

    @Test
    public void verifyAndValidateContactUsForm() {
        // Create Extent Report Test
        ExtentTest test = extent.createTest("TC_Ecom_Sanity_010 - Verify and Validate Contact Us Form");

        // Get Browser Name from RemoteWebDriver
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        test.info("Browser launched: " + browserName);

        try {
            // Step 1: Open the Automation Exercise URL
            driver.get("https://www.automationexercise.com/");
            test.info("Opened URL: https://www.automationexercise.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 2: Click on the "Contact Us" button in the header
            WebElement contactUsButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Contact us']")));
            contactUsButton.click();
            test.info("Clicked on 'Contact Us' button");

            // Step 3: Verify the "Get In Touch" form is displayed
            WebElement getInTouchHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[normalize-space()='Get In Touch']")));

            if (getInTouchHeader.isDisplayed()) {
                test.pass("'Contact Us' form is displayed successfully");
            } else {
                test.fail("'Contact Us' form is NOT displayed");
            }

            // Step 4: Fill in the contact form
            WebElement nameInput = driver.findElement(By.name("name"));
            WebElement emailInput = driver.findElement(By.name("email"));
            WebElement subjectInput = driver.findElement(By.name("subject"));
            WebElement messageInput = driver.findElement(By.id("message"));

            nameInput.clear();
            nameInput.sendKeys("Vinod Kumar");
            emailInput.clear();
            emailInput.sendKeys("vinodkumar12@gmail.com");
            subjectInput.clear();
            subjectInput.sendKeys("Automation Testing");
            messageInput.clear();
            messageInput.sendKeys("This is an automated test message to verify the Contact Us form.");
            test.info("Filled out the contact form with test data");

            // Step 5: Click the "Submit" button
            WebElement submitButton = driver.findElement(By.name("submit"));
            submitButton.click();
            test.info("Clicked on 'Submit' button");

            // Step 6: Handle the alert popup
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            test.info("Accepted the alert popup after submitting the form");

            // Step 7: Verify success message
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='status alert alert-success' and contains(text(),'Success! Your details have been submitted successfully.')]")
            ));

            if (successMsg.isDisplayed()) {
                test.pass("PASS - Contact Us form submitted successfully and success message displayed");
            } else {
                test.fail("FAIL - Contact Us form submission failed");
            }

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
