package ProductPage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_TestCase_15 extends BaseTest {

    @Test
    public void verifySearchButtonFunctionality() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_ECOM_TestCase_15 - Verify Search Button Click Functionality in Product Page");

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

        // Locate the Search Box and Enter a Value
        try {
            WebElement searchBox = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.id("search_product")));
            searchBox.clear();
            searchBox.sendKeys("Blue Top");

            // Locate and Click the Search Button
            WebElement searchBtn = wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("submit_search")));
            searchBtn.click();
            test.pass("Successfully clicked on the search button after entering 'Laptop'.");

            // Wait for the results to load
            Thread.sleep(2000);

            // Assertion → Verify that search results are displayed
            WebElement firstProduct = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='productinfo text-center']/p")));

            Assert.assertTrue(firstProduct.isDisplayed(),
                "Search results were not displayed after clicking the search button!");

        } catch (Exception e) {
            test.fail("Search button is not working properly.")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "SearchButtonNotWorking"));
            Assert.fail("Search button failed to display results: " + e.getMessage());
        }

        // Close the Browser Window after delay
        driver.quit();
    }
}
