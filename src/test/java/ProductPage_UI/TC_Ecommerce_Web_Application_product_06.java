package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_06 extends BaseTest {

    @Test
    public void verifyApiTestingButtonInProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_06 - Verify API Testing button in Product page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Click on 'API Testing' button
            WebElement apiBtn = driver.findElement(By.xpath("//a[@href='/api_list']"));
            apiBtn.click();
            test.pass("Clicked on 'API Testing' button");

            // Step 3: Verify navigation by checking URL
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("/api_list"), 
                    "Did not navigate to API Testing page. Current URL: " + currentUrl);
            test.pass("Successfully navigated to API Testing page: " + currentUrl);

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
