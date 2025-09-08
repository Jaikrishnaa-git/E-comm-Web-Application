package ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_ECOM_TestCase_25 extends BaseTest {

    @Test
    public void verifyNameInputInProductPage() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_TestCase_25 - Verify Name input in Product Page");

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

        // Step 3: Click on 'View Product' for Stylish Dress to go to product details page
        WebElement stylishDressImage = driver.findElement(
            By.xpath("//div[@class='product-image-wrapper'][.//p[text()='Stylish Dress']]")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stylishDressImage);
        Thread.sleep(1000);

        WebElement viewProductBtn = stylishDressImage.findElement(
            By.xpath(".//a[contains(text(),'View Product')]")
        );
        wait.until(ExpectedConditions.elementToBeClickable(viewProductBtn));
        viewProductBtn.click();
        test.info("Clicked on View Product button for Stylish Dress.");

        // Step 4: Locate Name input field in product page
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@id='name']")  // Adjust ID if different
        ));

        // Step 5: Enter valid input in Name field
        nameInput.clear();
        nameInput.sendKeys("Vinod Reddy");  // Example valid name
        test.info("Entered valid input in Name field: Vinod Reddy");

        // Validate that value is correctly entered
        String enteredName = nameInput.getAttribute("value");
        Assert.assertEquals(enteredName, "Vinod Reddy", "Name input value mismatch!");

        test.pass("Successfully entered valid name in the product page.");
    }
}
