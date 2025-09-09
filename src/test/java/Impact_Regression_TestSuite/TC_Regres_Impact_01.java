package Impact_Regression_TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Regres_Impact_01 extends BaseTest {

    @Parameters("browser")
    @Test
    public void verifySignupLoginPageLoads() {
        // Create Extent Report entry
        test = extent.createTest("TC_Regres_Impact_01 - Verify Signup/Login page loads in the browser");

        try {
            // Step 1: Open the login URL
            driver.get("https://www.automationexercise.com/login");
            test.info("Opened URL: https://www.automationexercise.com/login");

            // Step 2: Check whether the page loads
            WebElement loginHeader = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
            Assert.assertTrue(loginHeader.isDisplayed(), "Signup/Login page did not load correctly");
            test.pass("Signup/Login page loaded successfully");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
