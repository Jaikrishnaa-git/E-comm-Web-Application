package UiApiPage;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_API_Testing_10 extends BaseTest {

    private final String apiPageUrl = "https://automationexercise.com/api_list";
    private final By logoLocator = By.xpath("//img[@alt='Website for practice automation']");

    @Test(groups = { "UI_Testing" })
    public void verifyLogoOnApiPage() {
        test = extent.createTest("TC_API_10 - Verify Logo Click on API Page");

        try {
            // Step 1: Open API Page
            driver.get(apiPageUrl);
            test.log(Status.INFO, "Opened API Testing Page: " + apiPageUrl);

            // Step 2: Wait for logo and click
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(logoLocator));
            logo.click();
            test.log(Status.INFO, "Clicked on website logo");

            // Step 3: Verify redirection to home page
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, "https://automationexercise.com/",
                    "Clicking logo did not redirect to Home Page. Current URL: " + actualUrl);

            test.pass("Logo is clickable and redirected to Home Page successfully.");
        } catch (Exception e) {
            test.fail("Logo click test failed: " + e.getMessage());
            Assert.fail("Logo click test failed: " + e.getMessage());
        }
    }
}
