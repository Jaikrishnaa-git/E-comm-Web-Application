package Corebusiness;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_regr_core_011 extends BaseTest {

    @Test
    public void verifyCartItemsQuantityAndPrice() throws IOException {
        test = extent.createTest("TC_regr_core_011 - Verify Cart displaying correct items with quantity and price");

        try {
          
            driver.get("https://automationexercise.com/products");
            test.info("Opened Products Page");

            WebElement firstProductAddBtn = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));
            firstProductAddBtn.click();
            test.info("Clicked Add to Cart for first product");

            driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
            test.info("Closed cart popup");

            firstProductAddBtn = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));
            firstProductAddBtn.click();
            test.info("Clicked Add to Cart again for same product");

            driver.findElement(By.linkText("View Cart")).click();
            test.info("Navigated to Cart page");
            WebElement quantityElement = driver.findElement(By.xpath("//button[@class='disabled']"));
            int quantity = Integer.parseInt(quantityElement.getText().trim());

            WebElement unitPriceElement = driver.findElement(By.xpath("//td[@class='cart_price']/p"));
            String priceText = unitPriceElement.getText().replaceAll("[^0-9]", "");
            int unitPrice = Integer.parseInt(priceText);

            WebElement totalPriceElement = driver.findElement(By.xpath("//td[@class='cart_total']/p"));
            String totalPriceText = totalPriceElement.getText().replaceAll("[^0-9]", "");
            int totalPrice = Integer.parseInt(totalPriceText);

            int expectedTotal = unitPrice * quantity;

            Assert.assertEquals(totalPrice, expectedTotal, "Cart total price mismatch");
            test.pass("Cart displays correct item, quantity (" + quantity + "), and total price (" + totalPrice + ")");

            String shot = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_011");
            test.addScreenCaptureFromPath(shot);

        } catch (Exception e) {
            String shot = ScreenshotUtilities.capturescreen(driver, "TC_regr_core_011_Fail");
            test.fail("Exception occurred: " + e.getMessage()).addScreenCaptureFromPath(shot);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}