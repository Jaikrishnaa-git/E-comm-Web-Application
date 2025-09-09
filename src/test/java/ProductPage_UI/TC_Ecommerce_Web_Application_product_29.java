package ProductPage_UI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_29 extends BaseTest {

    @Test
    public void verifyTopButtonInProductPage() throws IOException {

        // Start Extent Report Test
        test = extent.createTest("TC_Ecommerce_Web_Application_product_29 - Verify #top button in Product Page");

        try {
            // Step 1: Open the Product Page
            driver.get("https://automationexercise.com/products");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            test.pass("Navigated to Product Page successfully.");

            // Step 2: Scroll Down first (to enable #top button effect)
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.END).perform();
            Thread.sleep(2000);
            test.info("Scrolled down using END key to reach bottom of page.");

            // Step 3: Click on #top button
            WebElement topButton = wait.until(ExpectedConditions
                    .elementToBeClickable(By.id("scrollUp")));
            topButton.click();
            Thread.sleep(2000);
            test.pass("Clicked on #top button successfully.");

            // Step 4: Validation → Check if page scrolled back up (header visible)
            WebElement productHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'All Products')]")));
            Assert.assertTrue(productHeader.isDisplayed(), "#top button did not scroll page up as expected!");
            test.pass("#top button functionality verified successfully. 'All Products' header visible.");

        } catch (Exception e) {
            test.fail("#top button not working as expected.");
            Assert.fail("Exception occurred while verifying #top button: " + e.getMessage());
        } finally {
            // Step 5: Close Browser
            driver.quit();
            test.info("Browser closed after test execution.");
        }
    }
}
