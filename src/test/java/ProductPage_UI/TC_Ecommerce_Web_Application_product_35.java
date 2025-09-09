package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_35 extends BaseTest {

    @Test
    public void verifyViewProductButtonInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_35 - Verify View Product Button in Product Page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/products");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 2: Locate first "View Product" button
            WebElement viewProductBtn = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("(//a[contains(text(),'View Product')])[1]")));

            // Step 3: Click on View Product button
            viewProductBtn.click();

            // Step 4: Verify Product Details Page is opened
            WebElement productDetails = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='product-information']")));

            Assert.assertTrue(productDetails.isDisplayed(), "Product Details Page did not load!");
            test.pass("Successfully clicked View Product button and navigated to product details page.");

        } catch (Exception e) {
            test.fail("View Product button test failed due to exception: " + e.getMessage());
            Assert.fail("View Product button test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
