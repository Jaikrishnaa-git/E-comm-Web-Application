package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_33 extends BaseTest {

    @Test
    public void verifySearchButtonInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_33 - Verify Search Button of Search Bar");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/products");

            // Step 2: Wait for search box and button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
            WebElement searchButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("submit_search")));

            // Step 3: Enter text and click search button
            searchBox.sendKeys("Tshirt");
            searchButton.click();

            // Step 4: Validate that search results are displayed
            WebElement searchResult = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h2[contains(text(),'Searched Products')]")));

            Assert.assertTrue(searchResult.isDisplayed(), "Search results not displayed!");
            test.pass("Search button clicked successfully and results displayed.");

        } catch (Exception e) {
            test.fail("Search button test failed due to exception: " + e.getMessage());
            Assert.fail("Search button test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
