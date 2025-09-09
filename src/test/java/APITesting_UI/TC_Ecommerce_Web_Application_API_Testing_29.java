package APITesting_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_API_Testing_29 extends BaseTest {

    @Test
    public void verifyAPIsListForPracticeIsVisible() {
        ExtentTest test = extent.createTest("TC_Ecommerce_Web_Application_API_Testing_29 - Verify APIs List for Practice is Visible");

        try {
            // Step 1: Open the API Testing page
            driver.get("https://automationexercise.com/api_list");
            test.info("Navigated to API Testing page");

            // Step 2: Wait until the "APIs List for practice" heading is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement apiListHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'APIs List for practice')]")));
            test.info("Located the 'APIs List for practice' heading successfully");

            // Step 3: Verify that heading is displayed
            Assert.assertTrue(apiListHeading.isDisplayed(), "'APIs List for practice' heading is not visible!");
            test.pass("'APIs List for practice' heading is visible as expected");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }
}
