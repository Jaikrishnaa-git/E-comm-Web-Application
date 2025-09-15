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

public class TC_ECOM_TestCase_29 extends BaseTest {

    @Test
    public void verifyInvalidEmailInputInProductPage() throws InterruptedException {

 
        test = extent.createTest("TC_ECOM_TestCase_29 - Verify Invalid Email input in Product Page");

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

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='email']")  
        ));

        emailInput.clear();
        String invalidEmail = "abc123@@invalid"; 
        emailInput.sendKeys(invalidEmail);
        test.info("Entered invalid email in Email field: " + invalidEmail);

      
        String enteredEmail = emailInput.getAttribute("value");
        boolean isInvalidAccepted = enteredEmail.equals(invalidEmail);

        Assert.assertFalse(isInvalidAccepted,
                "Invalid email should not be accepted in Email field, but it was!");

        test.pass("Invalid email input was not accepted in the product page.");
    }
}