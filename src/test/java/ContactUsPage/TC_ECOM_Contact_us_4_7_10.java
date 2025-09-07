package ContactUsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_ECOM_Contact_us_4_7_10 extends BaseTest {

    @Test
    public void verifyValidNameInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_4 - Verify Valid Name,email,subject in Name,email,subject Text box in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.enterName("Test User");
        contactUs.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        contactUs.enterSubject("Automation Test");
        contactUs.enterMessage("This is automation testing of contact us page test cases.");

        contactUs.clickSubmit();

        driver.switchTo().alert().accept();

        String successMessage = driver.findElement(By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]")).getText();

        if (successMessage.contains("Success!")) {
            test.pass("Form submitted successfully with valid Name and other details")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_04_07_10"));;
        } else {
            test.fail("Form submission failed or success message not displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_04_07_10"));
            Assert.fail("Contact Us form submission failed after entering valid details");
        }
    }
}
