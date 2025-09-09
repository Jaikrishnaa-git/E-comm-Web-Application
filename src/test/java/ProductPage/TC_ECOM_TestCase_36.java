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

public class TC_ECOM_TestCase_36 extends BaseTest {

    @Test
    public void verifyProductBrandInProductPage() throws InterruptedException {

        // Create Extent Report entry
        test = extent.createTest("TC_ECOM_TestCase_36 - Verify Product Brand in Product Page");

        // Step 1: Open Automation Exercise website
        driver.get("https://automationexercise.com/");
        test.info("Opened Automation Exercise website.");

        // Step 2: Click on 'Products' menu
        WebElement productsMenu = driver.findElement(By.xpath("//a[@href='/products']"));
        productsMenu.click();
        test.info("Navigated to Products page.");

        // Step 3: Wait until products are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));

        // Step 4: Click 'View Product' for Stylish Dress
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

        // Step 5: Wait for product information container
        WebElement productInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='product-information']")
        ));

        // Step 6: Locate the Brand element
        WebElement brandElement = productInfo.findElement(
            By.xpath(".//b[text()='Brand:']/parent::p")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandElement);
        Thread.sleep(1000); // Optional: for visual confirmation

        // Step 7: Verify that brand is displayed
        String brandText = brandElement.getText();
        Assert.assertTrue(brandText.contains("Brand"), "Product brand is not displayed!");
        test.info("Product brand is visible: " + brandText);

        test.pass("Successfully verified that product brand is visible on the product page.");
    }
}
