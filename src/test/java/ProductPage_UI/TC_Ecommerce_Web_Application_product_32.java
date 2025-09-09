package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_32 extends BaseTest {

    @Test
    public void verifySearchBarInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_32 - Verify Search Bar in Product Page");

        try {
            // Step 1: Open URL
            driver.get("https://automationexercise.com/products");

            // Step 2: Wait for search box to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));

            // Step 3: Enter text into search bar
            String inputText = "Tshirt";
            searchBox.sendKeys(inputText);

            // Validation
            Assert.assertEquals(searchBox.getAttribute("value"), inputText, "Text not entered properly!");
            test.pass("User was able to enter text in the search bar successfully.");

        } catch (Exception e) {
            test.fail("Search bar test failed due to exception: " + e.getMessage());
            Assert.fail("Search bar test failed due to exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
