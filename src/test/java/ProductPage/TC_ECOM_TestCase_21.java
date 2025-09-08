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

public class TC_ECOM_TestCase_21 extends BaseTest {

    @Test
    public void verifyViewProductSleevelessDress() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_TestCase_21 - Verify View Product for Sleeveless Dress");

        // Step 1: Open Automation Exercise website
        driver.get("https://automationexercise.com/");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on 'Products' menu to navigate to All Products page
        WebElement productsMenu = driver.findElement(By.xpath("//a[@href='/products']"));
        productsMenu.click();
        test.info("Navigated to Products page.");

        // Wait until products are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));

        // Step 3: Scroll down to the Sleeveless Dress product
        WebElement sleevelessDressImage = driver.findElement(
            By.xpath("//div[@class='product-image-wrapper'][.//p[text()='Sleeveless Dress']]")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sleevelessDressImage);
        Thread.sleep(1000);

        // Step 4: Hover over Sleeveless Dress to reveal View Product button
        Actions actions = new Actions(driver);
        actions.moveToElement(sleevelessDressImage).perform();
        Thread.sleep(1000);

        // Step 5: Locate and click on the View Product button
        WebElement viewProductBtn = sleevelessDressImage.findElement(
            By.xpath(".//a[contains(text(),'View Product')]")
        );
        wait.until(ExpectedConditions.elementToBeClickable(viewProductBtn));
        viewProductBtn.click();
        test.info("Clicked on View Product button for Sleeveless Dress.");

        // Step 6: Validate that product details page is displayed
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='product-information']/h2")
        ));

        String actualTitle = productTitle.getText();
        Assert.assertEquals(actualTitle.trim(), "Sleeveless Dress", "Product title mismatch!");

        test.pass("Successfully navigated to Sleeveless Dress product details page.");
    }
}
