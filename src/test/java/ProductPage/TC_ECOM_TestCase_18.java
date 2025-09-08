package ProductPage;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_ECOM_TestCase_18 extends BaseTest {

    @Test
    public void verifyAddBlueTopToCart() {
        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_18 - Verify Add to Cart Button for Blue Top in Product Page");

        // Open Home Page URL
        driver.get("https://www.automationexercise.com/");

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Click on "Products" button
            WebElement productsButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
            productsButton.click();
            test.pass("Clicked on the Products button successfully.");

            // Step 2: Wait until products are visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));
            test.pass("Products page loaded successfully.");

            // Step 3: Locate Blue Top "Add to Cart" button dynamically using data-product-id='1'
            WebElement blueTopAddToCart = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]")));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blueTopAddToCart);
            Thread.sleep(500);

            // Step 4: Click on Add to Cart button for Blue Top
            try {
                blueTopAddToCart.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", blueTopAddToCart);
            }
            test.pass("Clicked on the Add to Cart button for Blue Top.");

            // Step 5: Handle confirmation modal
            WebElement continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Continue Shopping')]")));
            continueShoppingButton.click();
            test.pass("Blue Top added to cart successfully and confirmation modal handled.");

            // Step 6: Navigate to Cart Page
            WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']")));
            cartButton.click();
            test.pass("Navigated to the cart page successfully.");

            // Step 7: Verify Blue Top is added to cart
            WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//td[@class='cart_description']/h4/a[text()='Blue Top']")));
            Assert.assertTrue(cartItem.isDisplayed(), "Blue Top was not added to the cart!");
            test.pass("Verified that Blue Top is added to the cart successfully.");

        } catch (Exception e) {
            test.fail("Failed to add Blue Top to the cart.");
            Assert.fail("Blue Top Add to Cart button failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
