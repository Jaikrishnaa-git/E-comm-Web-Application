package ContactUsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_ECOM_Contact_us_6_9_11_16 extends BaseTest {

    @Test
    public void verifyNoInputsForNameEmailSubject() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_NoInputs - Verify No Inputs for Name, Email, Subject in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        contactUs.enterName("");
        contactUs.enterEmail("");
        contactUs.enterSubject("");
        contactUs.enterMessage("Testing with no name, email, and subject");

        contactUs.clickSubmit();
        driver.switchTo().alert().accept();

        boolean successDisplayed = driver.findElements(
                By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]")
        ).size() > 0;

        if (!successDisplayed) {
            test.pass("Form not submitted when Name, Email, and Subject are empty")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_06_09_11_16"));;
        } else {
            test.fail("Form accepted submission with empty Name, Email, and Subject!")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ContactUs_06_09_11_16"));
            Assert.fail("Form accepted empty inputs for Name, Email, and Subject");
        }
    }
}
