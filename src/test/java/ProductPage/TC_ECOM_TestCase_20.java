package ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_TestCase_20 extends BaseTest {

    @Test
    public void verifyAddToCartSleevelessDress() throws InterruptedException {
        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_TestCase_20 - Verify Add to Cart for Sleeveless Dress");

        // Step 1: Open Automation Exercise website
        driver.get("https://automationexercise.com/");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on 'Products' menu to navigate to All Products page
        WebElement productsMenu = driver.findElement(By.xpath("//a[@href='/products']"));
        productsMenu.click();
        test.info("Navigated to Products page.");

        // Wait until products are loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));

        // Step 3: Locate the Sleeveless Dress product
        WebElement sleevelessDress = driver.findElement(
            By.xpath("//div[@class='productinfo text-center']/p[contains(text(),'Sleeveless Dress')]")
        );

        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sleevelessDress);
        Thread.sleep(1000);

        // Step 4: Hover over the Sleeveless Dress product to make Add to Cart button visible
        Actions actions = new Actions(driver);
        actions.moveToElement(sleevelessDress).perform();
        Thread.sleep(1000);

        // Step 5: Locate the Add to Cart button
        WebElement addToCartBtn = driver.findElement(
            By.xpath("//p[contains(text(),'Sleeveless Dress')]/following-sibling::a[contains(text(),'Add to cart')]")
        );

        // Wait until the button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        try {
            // Try normal Selenium click first
            addToCartBtn.click();
        } catch (Exception e) {
            // If intercepted, use JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
        }

        test.info("Clicked on Add to Cart button for Sleeveless Dress.");

        // Step 6: Wait for success modal popup
        WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='modal-content']//h4")
        ));
        String successMsg = successModal.getText();
        Assert.assertTrue(successMsg.contains("Added"), "Add to Cart failed!");
        test.pass("Sleeveless Dress added to cart successfully.");

        // Step 7: Close modal by clicking 'Continue Shopping'
        WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"));
        continueBtn.click();
        test.info("Closed the cart modal and continued shopping.");
    }
}
