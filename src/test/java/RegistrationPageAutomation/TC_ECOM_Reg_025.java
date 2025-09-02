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
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_025 - Verify Year Dropdown in Signup Page");

        SignupPage signup = new SignupPage(driver);

        signup.enterName("TestUser");
        signup.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        if (signup.isYearDropdownDisplayed()) {
            test.pass("Year dropdown is displayed");
        } else {
            test.fail("Year dropdown is NOT displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "YearDropdownNotDisplayed"));
            Assert.fail("Year dropdown not displayed");
        }

        int optionCount = signup.getYearOptionsCount();
        if (optionCount > 50) {
            test.pass("Year dropdown has more than 50 options: " + optionCount);
        } else {
            test.fail("Year dropdown has insufficient options: " + optionCount)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "YearDropdownOptions"));
            Assert.fail("Year dropdown has insufficient options");
        }

        signup.selectYear("1995");
        String selectedYear = signup.getSelectedYear();

        if (selectedYear.equals("1995")) {
            test.pass("Successfully selected year 1995");
        } else {
            test.fail("Failed to select year 1995, selected: " + selectedYear)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "YearSelectionFailed"));
            Assert.fail("Year selection mismatch");
        }
    }
}
