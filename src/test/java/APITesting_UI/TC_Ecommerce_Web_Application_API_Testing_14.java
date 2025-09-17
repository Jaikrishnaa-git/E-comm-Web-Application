package APITesting_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

public class TC_Ecommerce_Web_Application_API_Testing_14 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyAPI1Dropdown() throws InterruptedException {
        // Start logging in Extent Report
        test = extent.createTest("TC_Ecommerce_Web_Application_API_Testing_14", "Verify and click on API 1 dropdown");

        // Step 1: Open Automation Exercise URL
        driver.get("https://automationexercise.com/");
        test.info("Opened Automation Exercise URL");

        // Step 2: Click on API Testing button
        WebElement apiTestingButton = driver.findElement(By.xpath("//a[@href='/api_list' and contains(text(),'API Testing')]"));
        apiTestingButton.click();
        test.info("Clicked on API Testing button");

        // Step 3: Click on API 1: Get All Products List
        WebElement api1Link = driver.findElement(By.xpath("//u[contains(text(),'API 1: Get All Products List')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", api1Link);
        api1Link.click();
        test.info("Clicked on API 1: Get All Products List");

        // Optional wait for demo purposes
        Thread.sleep(2000);

        test.pass("✅ Successfully clicked on API 1 dropdown");
        System.out.println("✅ Clicked on API 1 successfully.");
    }
}
