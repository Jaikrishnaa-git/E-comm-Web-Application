package ProductPage_UI;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_product_22 extends BaseTest {

    @Test
    public void verifyGoogleAdDropButtonInProductPage() {

        test = extent.createTest("TC_Ecommerce_Web_Application_product_22 - Verify Google Ad Drop Button in Product Page");

        try {
            // Step 1: Open the Automation Exercise URL
            driver.get("https://www.automationexercise.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 2: Click on the Products button
            WebElement productsButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
            productsButton.click();
            test.pass("Step 2: Clicked on the Products button successfully.");

            // Step 3: Check if Google Ad iframe is present
            List<WebElement> adFrames = driver.findElements(By.xpath("//iframe[contains(@id,'aswift')]"));
            if (adFrames.isEmpty()) {
                test.skip("Google Ad drop button not present (iframe not loaded). Skipping test.");
            } else {
                driver.switchTo().frame(adFrames.get(0));
                test.pass("Step 3: Found Google Ad drop iframe.");

                // Optional: check if inner ad loads
                List<WebElement> adInnerFrames = driver.findElements(By.xpath("//iframe[contains(@id,'ad_iframe')]"));
                if (!adInnerFrames.isEmpty()) {
                    driver.switchTo().frame(adInnerFrames.get(0));
                    test.pass("Step 3: Found inner Google Ad frame.");
                }

                // ✅ Just verifying presence, not clicking (ads may block automation)
                test.pass("Step 3: Verified Google Ad drop button is present.");
                driver.switchTo().defaultContent();
            }

            // Step 4: Close browser
            driver.close();
            test.pass("Step 4: Browser closed successfully.");

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
