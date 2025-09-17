package APITesting_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_API_Testing_16 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyAPI3Dropdown() throws InterruptedException {
        // Create Extent Test
        test = extent.createTest("TC_Ecommerce_Web_Application_API_Testing_16", "Verify and click on API 3 dropdown");

        // Step 1: Open Automation Exercise URL
        driver.get("https://automationexercise.com/");
        test.info("Opened Automation Exercise URL");

        // Step 2: Click on API Testing button
        WebElement apiTestingButton = driver.findElement(By.xpath("//a[@href='/api_list' and contains(text(),'API Testing')]"));
        apiTestingButton.click();
        test.info("Clicked on API Testing button");

        // Step 3: Click on API 3 using position-based XPath with explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement api3Link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//u[contains(text(),'API')])[3]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", api3Link);
        api3Link.click();
        test.info("Clicked on API 3");

        // Optional wait for demo purposes
        Thread.sleep(2000);

        test.pass("✅ Successfully clicked on API 3 dropdown");
        System.out.println("✅ Clicked on API 3 successfully.");
    }
}
