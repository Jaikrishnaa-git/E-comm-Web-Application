package RegistrationPageAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Ecomm.base.BaseTest;
import com.Ecomm.pages.SignupPage;
import com.Ecomm.utilities.ScreenshotUtilities;

public class TC_ECOM_Reg_026 extends BaseTest {

    @Test
    public void verifyDateWithMonthInSignupPage() throws IOException {
        driver.get("https://www.automationexercise.com/signup");
        test = extent.createTest("TC_ECOM_Reg_026 - Verify Date with Month in Signup Page");

        SignupPage signup = new SignupPage(driver);

        signup.enterName("TestUser");
        signup.enterEmail("testuser" + System.currentTimeMillis() + "@gmail.com");
        signup.clickSignupButton();

        if (signup.isDayDropdownDisplayed() && signup.isMonthDropdownDisplayed()) {
            test.pass("Day and Month dropdowns are displayed");
        } else {
            test.fail("Day or Month dropdown is NOT displayed")
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "DayMonthDropdownNotDisplayed"));
            Assert.fail("Day or Month dropdown not displayed");
        }

        signup.selectDay("31");
        signup.selectMonth("February");

        String selectedDay = signup.getSelectedDay();
        String selectedMonth = signup.getSelectedMonth();

        if (selectedDay.equals("31") && selectedMonth.equals("February")) {
            
            test.fail("Invalid date-month combination allowed: " + selectedDay + " " + selectedMonth)
                .addScreenCaptureFromPath(ScreenshotUtilities.capturescreen(driver, "InvalidDateMonth"));
            Assert.fail("Application allowed invalid date-month combination");
        } else {
            test.pass("Application correctly restricted invalid date-month selection");
        }
    }
}
