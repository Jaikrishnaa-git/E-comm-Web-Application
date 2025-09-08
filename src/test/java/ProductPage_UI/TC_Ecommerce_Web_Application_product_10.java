package ProductPage_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_10 extends BaseTest {

    @Test
    public void verifyLogoFromProductPage() {
        test = extent.createTest("TC_Ecommerce_Web_Application_product_10 - Verify Logo from Product page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/product");
            test.info("Opened URL: https://automationexercise.com/product");

            // Step 2: Click on Product button to go to /products
            WebElement productBtn = driver.findElement(By.xpath("//a[@href='/products']"));
            productBtn.click();
            test.pass("Clicked on Product button");

            // Step 3: Locate the Logo
            WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png' and @alt='Website for automation practice']"));
            Assert.assertTrue(logo.isDisplayed(), "Logo is not visible on the page");
            test.pass("Logo is displayed on the Product page");

            // Step 4: Click on the Logo
            logo.click();
            test.pass("Clicked on the Logo successfully");

            // Step 5: Validate redirection to Homepage
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://automationexercise.com/",
                    "Clicking on the logo did not navigate to Home page");
            test.pass("Clicking on Logo navigated to Home page: " + currentUrl);

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed after execution");
        }
    }
}
