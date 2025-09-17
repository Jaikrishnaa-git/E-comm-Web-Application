package UiTestcasePage;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_testcase_10 extends BaseTest {

    private final String testCasesUrl = "https://automationexercise.com/test_cases";
    private final By logo = By.cssSelector("div.logo.pull-left img");

    @Test(groups = { "UI_Testing" })
    public void verifyLogoClick() {
        test = extent.createTest("TC_10 - Verify Logo Click");

        try {
            driver.get(testCasesUrl);
            test.log(Status.INFO, "Opened Test Cases page");

            // Wait for logo
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logoElement = wait.until(ExpectedConditions.elementToBeClickable(logo));

            logoElement.click();
            test.log(Status.INFO, "Clicked on logo");

            // Verify navigation
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://automationexercise.com/",
                    "Logo did not navigate to Home Page.");

            test.pass("✅ Logo navigated to Home Page successfully.");
        } catch (Exception e) {
            test.fail("❌ Logo click test failed: " + e.getMessage());
            Assert.fail("Logo click test failed: " + e.getMessage());
        }
    }
}
