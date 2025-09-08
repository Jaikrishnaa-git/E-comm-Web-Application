package ProductPage;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_ECOM_TestCase_19 extends BaseTest {

    @Test
    public void verifyViewProductForBlueTop() {
        // Start Extent Report
        test = extent.createTest("TC_ECOM_TestCase_19 - Verify View Product Button for Blue Top");

        // Open Homepage
        driver.get("https://www.automationexercise.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        try {
            // Step 1: Click on "Products" page
            WebElement productsButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
            productsButton.click();
            test.pass("Clicked on Products button successfully.");

            // Step 2: Wait for Products page to load
            wait.until(ExpectedConditions.urlContains("/products"));
            test.pass("Products page loaded successfully.");

            // Step 3: Locate "View Product" button for Blue Top
            WebElement viewProductButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='/product_details/1']")));

            // Scroll into view if hidden
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProductButton);
            Thread.sleep(500);

            // Click View Product button
            try {
                viewProductButton.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewProductButton);
            }
            test.pass("Clicked on View Product button for Blue Top.");

            // Step 4: Wait for Product Details page to load
            wait.until(ExpectedConditions.urlContains("/product_details/1"));
            test.pass("Blue Top product details page loaded successfully.");

            // Step 5: Verify Product Title
            WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='product-information']//h2")));

            String actualTitle = productTitle.getText().trim();
            Assert.assertEquals(actualTitle, "Blue Top", "Blue Top product details page did not open!");
            test.pass("Verified that Blue Top product details page opened successfully.");

        } catch (Exception e) {
            test.fail("Failed to click View Product button for Blue Top.");
            Assert.fail("View Product button validation failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
