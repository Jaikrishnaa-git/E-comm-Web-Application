package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_product_01 extends BaseTest {

    @Test
    public void verifyHomeButtonInProductPage() {
        ExtentTest test = extent.createTest(
            "TC_Ecommerce_Web_Application_product_01 - Verify Login/Signup button in Product page"
        );

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Wait until Login/Signup button is clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']")));
            test.info("Login/Signup button located successfully");

            // Step 3: Click on Login/Signup button
            loginBtn.click();
            test.pass("Clicked on Login/Signup button");

            // Step 4: Assertion - check login page is displayed
            WebElement loginPageHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Login to your account')]"))
            );
            Assert.assertTrue(loginPageHeader.isDisplayed(), "Login page is not displayed!");
            test.pass("Login/Signup page opened successfully and verified");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            test.info("Test execution completed for: TC_Ecommerce_Web_Application_product_01");
        }
    }
}
