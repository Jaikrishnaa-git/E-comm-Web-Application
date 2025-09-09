package ProductPage_UI;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_12 extends BaseTest {

    @Test
    public void verifyMenDropdownInProductPage() {

        // Start Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_product_12 - Verify Men Dropdown Button in Product Page");

        try {
            // Step 1: Open Product Page URL
            driver.get("https://automationexercise.com/products");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 2: Locate Men dropdown (from sidebar category)
            WebElement menDropdown = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//a[@href='#Men']")));

            // Step 3: Click Men dropdown
            menDropdown.click();

            // Step 4: Verify subcategories under Men are visible
            WebElement subCategory = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@id='Men']//a[contains(text(),'Tshirts')]")));

            Assert.assertTrue(subCategory.isDisplayed(), "Men dropdown did not expand properly!");
            test.pass("Successfully clicked on Men dropdown and subcategories are displayed.");

        } catch (Exception e) {
            test.fail("Men dropdown button test failed due to exception: " + e.getMessage());
            Assert.fail("Men dropdown test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
