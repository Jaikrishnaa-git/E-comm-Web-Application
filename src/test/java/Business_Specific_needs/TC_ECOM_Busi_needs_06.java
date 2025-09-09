package Business_Specific_needs;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.BusinessSpecificNeedsPage;
import com.aventstack.extentreports.Status;

public class TC_ECOM_Busi_needs_06 extends BaseTest {

    @Test
    public void verifyAPIListForPracticeIsVisible() {
        test = extent.createTest("TC_ECOM_Busi_needs_06 - Verify API List for practice text");

        driver.get("https://automationexercise.com/api_list");
        test.log(Status.INFO, "Navigated to API List page");

        BusinessSpecificNeedsPage page = new BusinessSpecificNeedsPage(driver);

        String actualText = page.getAPIListHeaderText();
        test.log(Status.INFO, "Fetched API List header text: " + actualText);

        try {
            Assert.assertTrue(actualText.equalsIgnoreCase("APIs List for practice"),
                "API List header text mismatch! Expected 'APIs List for practice' but got: " + actualText);
            test.log(Status.PASS, "API List for practice is visible as expected");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "API List header not found or text mismatch. Actual: " + actualText);
            throw e;
        }
    }
}
