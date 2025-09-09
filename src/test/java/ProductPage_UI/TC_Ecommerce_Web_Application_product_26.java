package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_Ecommerce_Web_Application_product_26 extends BaseTest {

    @Test
    public void verifySearchBarWithValidInput() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_26 - Verify Search Bar with Valid Input in Product Page");

        // Open the Home Page URL
        driver.get("https://www.automationexercise.com/");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

        // Locate the Search Bar and Enter a Valid Input
        try {
            WebElement searchBox = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.id("search_product")));
            searchBox.clear();
            searchBox.sendKeys("Men Tshirt");

            WebElement searchBtn = driver.findElement(By.id("submit_search"));
            searchBtn.click();

            test.pass("Successfully entered valid input 'Laptop' in search bar and clicked search.");

            // Wait for results to load
            Thread.sleep(2000);

            // Assertion → Verify search results are displayed
            WebElement firstProduct = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='productinfo text-center']/p")));

            Assert.assertTrue(firstProduct.isDisplayed(),
                "Search results are not displayed for the input!");

        } catch (Exception e) {
            test.fail("Search bar is not working with valid input.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "SearchBarNotWorking"));
            Assert.fail("Search bar did not return results: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
