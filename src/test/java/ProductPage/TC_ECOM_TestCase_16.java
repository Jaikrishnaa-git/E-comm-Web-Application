package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_16 extends BaseTest {

    @Test
    public void verifyAddSpecificProductsToCart() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_16 - Verify Add to Cart for Blue Top & Men Tshirt in Product Page");

        // Open the Home Page URL
        driver.get("https://www.automationexercise.com/");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        // Locate and Click on the Products Button
        try {
            WebElement productsButton = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[@href='/products']")));
            productsButton.click();
            test.pass("Clicked on the Products button successfully.");
        } catch (Exception e) {
            test.fail("Failed to click on Products button.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "ProductsButtonNotClickable"));
            Assert.fail("Products button is not clickable: " + e.getMessage());
        }

        try {
            // Wait until products are visible on the product page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));

            // **Step 1 → Add Blue Top to Cart**
            WebElement blueTopProduct = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//p[text()='Blue Top']/ancestor::div[@class='product-image-wrapper']")));
            actions.moveToElement(blueTopProduct).perform();
            WebElement blueTopAddToCart = blueTopProduct.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
            blueTopAddToCart.click();
            test.pass("Successfully added 'Blue Top' to cart.");

            // Close modal after adding Blue Top
            WebElement modalCloseBtn1 = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//button[@data-dismiss='modal']")));
            modalCloseBtn1.click();
            Thread.sleep(1000);

            // **Step 2 → Add Men Tshirt to Cart**
            WebElement menTshirtProduct = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//p[text()='Men Tshirt']/ancestor::div[@class='product-image-wrapper']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menTshirtProduct);
            actions.moveToElement(menTshirtProduct).perform();
            WebElement menTshirtAddToCart = menTshirtProduct.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
            menTshirtAddToCart.click();
            test.pass("Successfully added 'Men Tshirt' to cart.");

            // Close modal after adding Men Tshirt
            WebElement modalCloseBtn2 = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//button[@data-dismiss='modal']")));
            modalCloseBtn2.click();
            Thread.sleep(1000);

            // **Step 3 → Go to Cart Page and Verify**
            WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart']")));
            cartButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='cart_info_table']")));

            boolean isBlueTopInCart = driver.findElements(By.xpath("//td[@class='cart_description']//a[contains(text(),'Blue Top')]")).size() > 0;
            boolean isMenTshirtInCart = driver.findElements(By.xpath("//td[@class='cart_description']//a[contains(text(),'Men Tshirt')]")).size() > 0;

            Assert.assertTrue(isBlueTopInCart, "'Blue Top' was not found in the cart!");
            Assert.assertTrue(isMenTshirtInCart, "'Men Tshirt' was not found in the cart!");

            test.pass("Verified both 'Blue Top' and 'Men Tshirt' are successfully added to cart.");

        } catch (Exception e) {
            test.fail("Failed to add specific products to cart.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "AddSpecificProductsFailed"));
            Assert.fail("Could not add Blue Top & Men Tshirt to cart: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
