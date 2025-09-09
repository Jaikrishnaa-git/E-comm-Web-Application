package Business_Specific_needs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_ECOM_Busi_needs_02_03 extends BaseTest {

    // Invalid Name Test
    @Test
    public void verifyInvalidNameInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_InvalidName - Verify Invalid Name in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.enterName("12345@@@"); 
        contactUs.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        contactUs.enterSubject("Automation Test");
        contactUs.enterMessage("Message with invalid name");

        contactUs.clickSubmit();
        driver.switchTo().alert().accept();

        boolean successDisplayed = driver.findElements(
                By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]")
        ).size() > 0;

        if (!successDisplayed) {
            test.pass("Form not submitted with invalid name")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_02_03"));;
        } else {
            test.fail("Form accepted invalid name!")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_02_03"));
            Assert.fail("Form accepted invalid name");
        }
    }

    // Invalid Email Test
    @Test
    public void verifyInvalidEmailInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_InvalidEmail - Verify Invalid Email in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.enterName("Test User");
        contactUs.enterEmail("invalidemail.com");
        contactUs.enterSubject("Automation Test");
        contactUs.enterMessage("Message with invalid email");

        contactUs.clickSubmit();
        driver.switchTo().alert().accept();

        boolean successDisplayed = driver.findElements(
                By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]")
        ).size() > 0;

        if (!successDisplayed) {
            test.pass("Form not submitted with invalid email")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_02_03"));;
        } else {
            test.fail("Form accepted invalid email!")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_Busi_needs_02_03"));
            Assert.fail("Form accepted invalid email");
        }
    }
}
