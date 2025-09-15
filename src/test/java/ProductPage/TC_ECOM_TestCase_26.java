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

public class TC_ECOM_TestCase_26 extends BaseTest {

    @Test
    public void verifyInvalidNameInputInProductPage() throws InterruptedException {

  
        test = extent.createTest("TC_ECOM_TestCase_26 - Verify Invalid Name input in Product Page");

   
        driver.get("https://automationexercise.com/");
        test.info("Opened Automation Exercise website.");


        WebElement productsMenu = driver.findElement(By.xpath("//a[@href='/products']"));
        productsMenu.click();
        test.info("Navigated to Products page.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='features_items']")));

        WebElement stylishDressImage = driver.findElement(
                By.xpath("//div[@class='product-image-wrapper'][.//p[text()='Stylish Dress']]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stylishDressImage);
        Thread.sleep(1000);

        WebElement viewProductBtn = stylishDressImage.findElement(
                By.xpath(".//a[contains(text(),'View Product')]"));
        wait.until(ExpectedConditions.elementToBeClickable(viewProductBtn));
        viewProductBtn.click();
        test.info("Clicked on View Product button for Stylish Dress.");

        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='name']") 
        ));

        nameInput.clear();
        String invalidName = "@#$%^^&*1234";
        nameInput.sendKeys(invalidName);
        test.info("Entered invalid input in Name field: " + invalidName);

        String enteredName = nameInput.getAttribute("value");
        boolean isInvalidAccepted = enteredName.equals(invalidName);

        Assert.assertFalse(isInvalidAccepted,
                "Invalid input should not be accepted in Name field, but it was!");

        test.pass("Invalid name input was not accepted in the product page.");
    }
}