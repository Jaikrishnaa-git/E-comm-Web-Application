package Business_Specific_needs;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.BusinessSpecificNeedsPage;
import com.aventstack.extentreports.Status;

public class TC_ECOM_Busi_needs_07 extends BaseTest {

	@Test(groups = { "Business_Specific_needs" })
    public void verifyVideoTutorialsRedirectsToYouTube() {
        test = extent.createTest("TC_Ecom_businessSpec_007 - Verify Video Tutorials redirects to YouTube");

        driver.get("https://www.automationexercise.com/");
        test.log(Status.INFO, "Opened Automation Exercise homepage");

        BusinessSpecificNeedsPage page = new BusinessSpecificNeedsPage(driver);

        // Step 2: Click on Video Tutorials
        page.clickVideoTutorials();
        test.log(Status.INFO, "Clicked on Video Tutorials link");

        // Step 3: Switch to new tab (YouTube opens in a new tab)
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Step 4: Verify redirected to YouTube
        String currentUrl = driver.getCurrentUrl();
        test.log(Status.INFO, "Redirected URL: " + currentUrl);

        try {
            Assert.assertTrue(currentUrl.contains("youtube.com"), 
                "Video tutorials did not redirect to YouTube. Actual URL: " + currentUrl);
            test.log(Status.PASS, "Video tutorials redirected to YouTube successfully");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Redirection failed. Expected YouTube, but got: " + currentUrl);
            throw e;
        }
    }
}
