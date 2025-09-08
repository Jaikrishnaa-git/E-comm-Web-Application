package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_04 extends BaseTest {

    @Test
    public void verifySignupLoginButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_04 - Verify Signup/Login button in Product page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Click on 'Signup / Login' button
            WebElement signupLoginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
            signupLoginBtn.click();
            test.pass("Clicked on 'Signup / Login' button");

            // Step 3: Assertion - Verify Login/Signup page loaded
            WebElement loginHeader = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
            Assert.assertTrue(loginHeader.isDisplayed(), "Login/Signup page is not displayed!");
            test.pass("Signup/Login page opened successfully");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
