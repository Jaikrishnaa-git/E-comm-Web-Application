package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_05 extends BaseTest {

    @Test
    public void verifyTestCasesButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_05 - Verify Test Cases button in Product page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Click on 'Test Cases' button
            WebElement testCasesBtn = driver.findElement(By.xpath("//a[@href='/test_cases']"));
            testCasesBtn.click();
            test.pass("Clicked on 'Test Cases' button");

            // Step 3: Assertion - Verify Test Cases page loaded
            WebElement header = driver.findElement(By.xpath("//b[contains(text(),'Test Cases')]"));
            Assert.assertTrue(header.isDisplayed(), "Test Cases page is not displayed!");
            test.pass("Test Cases page opened successfully");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
