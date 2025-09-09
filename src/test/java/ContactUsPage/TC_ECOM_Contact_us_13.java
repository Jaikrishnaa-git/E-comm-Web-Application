package ContactUsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_ECOM_Contact_us_13 extends BaseTest {

    @Test
    public void verifyNoMessageInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_13 - Verify No Input in Your Message Text box in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.enterName("Test User");
        contactUs.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        contactUs.enterSubject("Automation Test");
        contactUs.enterMessage(""); // No input

        contactUs.clickSubmit();
        driver.switchTo().alert().accept();

        boolean successDisplayed = driver.findElements(
                By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]")
        ).size() > 0;

        if (!successDisplayed) {
            test.pass("Form not submitted when message box is empty");
        } else {
            test.fail("Form submitted successfully without message input (unexpected)")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_13"));
            Assert.fail("Form allowed submission without entering a message");
        }
    }
}

