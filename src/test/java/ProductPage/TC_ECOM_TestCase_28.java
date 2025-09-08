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

public class TC_ECOM_TestCase_28 extends BaseTest {

    @Test
    public void verifyEmailInputInProductPage() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_TestCase_28 - Verify Email input in Product Page");

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

        // Step 4: Locate Email input field in product page
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@id='email']")  // Adjust ID if different
        ));

        // Step 5: Enter valid email
        emailInput.clear();
        emailInput.sendKeys("vinod.reddy@example.com");  // Example valid email
        test.info("Entered valid email: vinod.reddy@example.com");

        // Validate that value is correctly entered
        String enteredEmail = emailInput.getAttribute("value");
        Assert.assertEquals(enteredEmail, "vinod.reddy@example.com", "Email input value mismatch!");

        test.pass("Successfully entered valid email in the product page.");
    }
}
