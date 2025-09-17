package ContactUsPage_UI;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.Contactuspage;
import com.Ecomm.utilities.ScreenshotUtilities;

import org.openqa.selenium.By;

public class TC_ECOM_ContactUs_UI_21 extends BaseTest {

	@Test(groups = { "UI_Testing" })
    public void verifyChooseFileButtonInContactUsPage() throws IOException {
        driver.get("https://www.automationexercise.com/contact_us");
        test = extent.createTest("TC_ECOM_Contact_us_14 - Verify Choose File button in Contact Us Page");

        Contactuspage contactUs = new Contactuspage(driver);

        File testFile = new File("src/test/resources/Testdata/sample.txt");

        if (!testFile.exists()) {
            test.fail("Test file not found: " + testFile.getAbsolutePath());
            Assert.fail("Required test file not found.");
        }

        contactUs.uploadFile(testFile.getAbsolutePath());

        String uploadedFilePath = driver.findElement(By.name("upload_file")).getAttribute("value");

        if (uploadedFilePath != null && !uploadedFilePath.isEmpty()) {
            test.pass("User was able to click and upload file using Choose File button")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_ContactUs_UI_21"));;
        } else {
            test.fail("Choose File button did not upload the file")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "TC_ECOM_ContactUs_UI_21"));
            Assert.fail("File not uploaded through Choose File button");
        }
    }
}
