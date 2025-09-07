package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_025 extends BaseTest {

    @Test
    public void verifyYearDropdownInSignupPage() throws IOException {
        driver.get("https://www.automationexercise.com/");
        test = extent.createTest("TC_ECOM_Reg_025 - Verify Year Dropdown in Signup Page");

        SignupPage signup = new SignupPage(driver);
        signup.goToSignupLogin();
        signup.newUserName("TestUser");
        signup.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        // Step 3: Validate dropdown visibility
        Assert.assertTrue(signup.isYearDropdownDisplayed(),
                "Year dropdown is NOT displayed");
        test.pass("✅ Year dropdown is displayed");

        // Validate option count
        int optionCount = signup.getYearOptionsCount();
        Assert.assertTrue(optionCount > 50,
                "Year dropdown has insufficient options: " + optionCount);
        test.pass("Year dropdown has more than 50 options: " + optionCount);

        // Select and validate year
        signup.selectYear("1995");
        String selectedYear = signup.getSelectedYear();
        Assert.assertEquals(selectedYear, "1995",
                "Year selection mismatch");

        test.pass("Successfully selected year 1995")
            .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "YearDropdownValidation"));
    }
}
