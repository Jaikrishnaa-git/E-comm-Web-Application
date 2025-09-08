package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_02 extends BaseTest {

    @Test
    public void verifyProductButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_02 - Verify Product button in Product page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Click on 'Products' button
            WebElement productsBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productsBtn.click();
            test.pass("Clicked on 'Products' button");

            // Step 3: Assertion - verify Products page is displayed
            WebElement productsPageHeader = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
            Assert.assertTrue(productsPageHeader.isDisplayed(), "Products page is not displayed!");
            test.pass("Products page opened successfully");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
