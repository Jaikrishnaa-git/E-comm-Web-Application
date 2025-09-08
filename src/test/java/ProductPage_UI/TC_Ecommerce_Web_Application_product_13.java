package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_13 extends BaseTest {

    @Test
    public void verifyKidsDropdownInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_13 - Verify Kids Dropdown Button in Product Page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/products");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 2: Locate Kids dropdown (from sidebar category)
            WebElement kidsDropdown = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[@href='#Kids']")));

            // Step 3: Click Kids dropdown
            kidsDropdown.click();

            // Step 4: Verify subcategories under Kids are visible
            WebElement subCategory = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@id='Kids']//a[contains(text(),'Dress')]")));

            Assert.assertTrue(subCategory.isDisplayed(), "Kids dropdown did not expand properly!");
            test.pass("Successfully clicked on Kids dropdown and subcategories are displayed.");

        } catch (Exception e) {
            test.fail("Kids dropdown button test failed due to exception: " + e.getMessage());
            Assert.fail("Kids dropdown test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
