package UiApiPage;

import com.Ecomm.base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Ecommerce_Web_Application_API_Testing_11_12_13 extends BaseTest {

    private final String apiPageUrl = "https://automationexercise.com/api_list";
    private final By subscriptionTextBox = By.xpath("//input[@id='susbscribe_email']");
    private final By subscriptionArrowButton = By.xpath("//button[@id='subscribe']");

    @Test(groups = { "UI_Testing" })
    public void verifySubscription() {
        test = extent.createTest("TC_API_Subscription - Verify Subscription in API Page");

        try {
            driver.get(apiPageUrl);
            test.log(Status.INFO, "Opened API Testing Page: " + apiPageUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down to subscription section
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            test.log(Status.INFO, "Scrolled to bottom of API Page");

            // Enter email in subscription text box
            WebElement subscriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTextBox));
            Assert.assertTrue(subscriptionField.isDisplayed(), "Subscription text box is not displayed");
            subscriptionField.sendKeys("kbharadwaj@gmail.com");
            test.log(Status.INFO, "Entered email into Subscription text box");

            // Click subscription arrow button
            WebElement arrowButton = wait.until(ExpectedConditions.elementToBeClickable(subscriptionArrowButton));
            Assert.assertTrue(arrowButton.isDisplayed(), "Subscription arrow button is not displayed");
            arrowButton.click();
            test.log(Status.INFO, "Clicked on Subscription arrow button");

            test.pass("Subscription test executed successfully.");
        } catch (Exception e) {
            test.fail("Subscription test failed: " + e.getMessage());
            Assert.fail("Subscription test failed: " + e.getMessage());
        }
    }
}
