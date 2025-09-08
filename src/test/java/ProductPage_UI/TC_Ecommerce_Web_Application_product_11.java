package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_11 extends BaseTest {

    @Test
    public void verifyWomenDropdownInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_11 - Verify Women Dropdown Button in Product Page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/products");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 2: Locate Women dropdown (from sidebar category)
            WebElement womenDropdown = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[@href='#Women']")));

            // Step 3: Click Women dropdown
            womenDropdown.click();

            // Step 4: Verify subcategories under Women are visible
            WebElement subCategory = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")));

            Assert.assertTrue(subCategory.isDisplayed(), "Women dropdown did not expand properly!");
            test.pass("Successfully clicked on Women dropdown and subcategories are displayed.");

        } catch (Exception e) {
            test.fail("Women dropdown button test failed due to exception: " + e.getMessage());
            Assert.fail("Women dropdown test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
