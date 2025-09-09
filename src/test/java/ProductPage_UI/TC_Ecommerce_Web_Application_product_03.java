package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_03 extends BaseTest {

    @Test
    public void verifyCartButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_03 - Verify Cart button in Product page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Click on 'Cart' button
            WebElement cartBtn = driver.findElement(By.xpath("//a[@href='/view_cart']"));
            cartBtn.click();
            test.pass("Clicked on 'Cart' button");

            // Step 3: Assertion - verify Cart page is displayed
            WebElement cartPageHeader = driver.findElement(By.xpath("//li[contains(text(),'Shopping Cart')]"));
            Assert.assertTrue(cartPageHeader.isDisplayed(), "Cart page is not displayed!");
            test.pass("Cart page opened successfully");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
