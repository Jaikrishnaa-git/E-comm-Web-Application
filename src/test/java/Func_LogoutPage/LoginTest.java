package Func_LogoutPage;





import java.io.IOException;



import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.Ecomm.base.BaseTest;

import com.Ecomm.pages.LoginPage;

import com.Ecomm.utilities.ExcelUtilities;

import com.Ecomm.utilities.ScreenshotUtilities;





public class LoginTest extends BaseTest {

 

 private LoginPage loginPage;


 private static final String VALID_EMAIL = "Jaikrishnaa@gmail.com";

 private static final String VALID_PASSWORD = "Team@A8";


 @BeforeMethod

 public void setUpTest() {
 driver.get("https://automationexercise.com/login");

 loginPage = new LoginPage(driver);

 System.out.println("Navigated to AutomationExercise login page");

 }

 

 @DataProvider(name = "loginTestData")

 public Object[][] getTestData() throws IOException {

 try {

 String excelPath = System.getProperty("user.dir") + "/src/test/resources/Testdata/data.xlsx";

 Object[][] data = ExcelUtilities.getdata(excelPath, "Sheet3");

 System.out.println("Excel data loaded from: " + excelPath);

 return data;

 } catch (Exception e) {

 System.err.println("Error loading Excel file: " + e.getMessage());

 throw e;

 }

 }

 

 @Test(dataProvider = "loginTestData", priority = 1)

 public void testValidEmailFormat(String email, String password) {

 test = extent.createTest("Email Format Validation Test - " + email);

 test.log(Status.INFO, "Testing email format validation: " + email);

 

 try {

 // Using page object method - NO direct UI interaction in test

 loginPage.enterEmail(email);

 

 // Business logic validation - This belongs in test class

 boolean isValidFormat = isValidEmailFormat(email);

 boolean actuallyValid = email.contains("@") && email.contains(".");

 

 if (isValidFormat) {

 Assert.assertTrue(actuallyValid, "Email should have valid format: " + email);

 test.log(Status.PASS, "Valid email format accepted: " + email);

 } else {

 Assert.assertFalse(actuallyValid, "Invalid email format should be rejected: " + email);

 test.log(Status.PASS, "Invalid email format correctly identified: " + email);

 }

 

 } catch (AssertionError e) {

 test.log(Status.FAIL, "Email format validation failed: " + e.getMessage());

 captureScreenshotOnFailure();

 throw e;

 } catch (Exception e) {

 test.log(Status.FAIL, "Email format test failed: " + e.getMessage());

 captureScreenshotOnFailure();

 Assert.fail("Test failed: " + e.getMessage());

 }

 }

 

 @Test(dataProvider = "loginTestData", priority = 2)

 public void testPasswordStrengthValidation(String email, String password) {

 test = extent.createTest("Password Strength Validation Test - " + email);

 test.log(Status.INFO, "Testing password strength: " + password);

 

 try {


 loginPage.enterPassword(password);



 boolean isStrongPassword = isPasswordStrong(password);

 boolean meetsMinimumRequirements = password.length() >= 6;

 

 if (isStrongPassword) {

 Assert.assertTrue(meetsMinimumRequirements, 

 "Strong password should meet minimum requirements: " + password);

 test.log(Status.PASS, "Strong password validation passed");

 } else {

 Assert.assertTrue(meetsMinimumRequirements, 

 "Weak password detected - should fail validation: " + password);

 test.log(Status.FAIL, "Weak password should not be accepted: " + password);

 }

 

 } catch (AssertionError e) {

 test.log(Status.FAIL, "Password strength validation failed: " + e.getMessage());

 captureScreenshotOnFailure();

 throw e;

 } catch (Exception e) {

 test.log(Status.FAIL, "Password strength test failed: " + e.getMessage());

 captureScreenshotOnFailure();

 Assert.fail("Test failed: " + e.getMessage());

 }

 }

 

 @Test(dataProvider = "loginTestData", priority = 3)

 public void testLoginAuthentication(String email, String password) {

 test = extent.createTest("Login Authentication Test - " + email);

 test.log(Status.INFO, "Testing login authentication with: " + email);

 

 try {


 loginPage.enterEmail(email);

 loginPage.enterPassword(password);

 loginPage.clickLoginButton();

 

 Thread.sleep(3000); // Wait for response

 

 // Business logic - determining expected vs actual results

 boolean shouldSucceed = VALID_EMAIL.equals(email) && VALID_PASSWORD.equals(password);

 boolean actuallySucceeded = loginPage.isLoggedIn(); // Page object method

 boolean hasErrorMessage = loginPage.isErrorMessageDisplayed(); // Page object method

 

 // Test assertions and reporting

 if (shouldSucceed) {

 Assert.assertTrue(actuallySucceeded, 

 "Login should succeed for valid credentials: " + email);

 test.log(Status.PASS, "Login successful for valid credentials: " + email);

 

 if (actuallySucceeded) {

 loginPage.logout(); // Page object method

 Thread.sleep(2000);

 }

 } else {

 Assert.assertFalse(actuallySucceeded, 

 "Login should fail for invalid credentials: " + email + "/" + password);

 

 if (hasErrorMessage) {

 test.log(Status.PASS, "Login correctly failed with error: " + loginPage.getErrorMessage());

 } else if (!actuallySucceeded) {

 test.log(Status.PASS, "Login correctly failed for: " + email);

 } else {

 test.log(Status.FAIL, "Login should have failed but succeeded for: " + email);

 }

 }

 

 } catch (AssertionError e) {

 test.log(Status.FAIL, "Login authentication assertion failed: " + e.getMessage());

 captureScreenshotOnFailure();

 throw e;

 } catch (Exception e) {

 test.log(Status.FAIL, "Login authentication test failed: " + e.getMessage());

 captureScreenshotOnFailure();

 Assert.fail("Test failed: " + e.getMessage());

 }

 }

 

 @Test(dataProvider = "loginTestData", priority = 4)

 public void testInvalidEmailRejection(String email, String password) {

 // Business logic - Skip valid emails for this test

 if (isValidEmailFormat(email)) {

 return;

 }

 

 test = extent.createTest("Invalid Email Rejection Test - " + email);

 test.log(Status.INFO, "Testing invalid email rejection: " + email);

 

 try {

 // Using page object methods only

 loginPage.enterEmail(email);

 loginPage.enterPassword("anypassword");

 loginPage.clickLoginButton();

 

 Thread.sleep(2000);

 

 // Getting results through page object methods

 boolean loginSucceeded = loginPage.isLoggedIn();

 boolean hasError = loginPage.isErrorMessageDisplayed();

 

 // Test assertions

 Assert.assertFalse(loginSucceeded, 

 "Login should not succeed with invalid email: " + email);

 

 if (hasError) {

 test.log(Status.PASS, "Invalid email correctly rejected with error: " + loginPage.getErrorMessage());

 } else {

 test.log(Status.PASS, "Invalid email correctly rejected: " + email);

 }

 

 } catch (AssertionError e) {

 test.log(Status.FAIL, "Invalid email rejection failed: " + e.getMessage());

 captureScreenshotOnFailure();

 throw e;

 } catch (Exception e) {

 test.log(Status.FAIL, "Invalid email rejection test failed: " + e.getMessage());

 captureScreenshotOnFailure();

 Assert.fail("Test failed: " + e.getMessage());

 }

 }

 

 @Test(dataProvider = "loginTestData", priority = 5)

 public void testCredentialMismatch(String email, String password) {

 // Business logic - Test cases where credentials don't match valid ones

 boolean isValidEmail = VALID_EMAIL.equals(email);

 boolean isValidPassword = VALID_PASSWORD.equals(password);

 

 // Skip if both are valid (covered in authentication test)

 if (isValidEmail && isValidPassword) {

 return;

 }

 

 test = extent.createTest("Credential Mismatch Test - " + email);

 test.log(Status.INFO, "Testing credential mismatch: " + email + " / " + password);

 

 try {

 // Using page object methods

 loginPage.enterEmail(email);

 loginPage.enterPassword(password);

 loginPage.clickLoginButton();

 

 Thread.sleep(3000);

 

 // Getting results through page object methods

 boolean loginSucceeded = loginPage.isLoggedIn();

 boolean hasError = loginPage.isErrorMessageDisplayed();

 

 // Test assertions

 Assert.assertFalse(loginSucceeded, 

 "Login should fail for credential mismatch - Email: " + email + ", Password: " + password);

 

 if (hasError) {

 test.log(Status.PASS, "Credential mismatch correctly handled with error: " + loginPage.getErrorMessage());

 } else {

 test.log(Status.PASS, "Credential mismatch correctly rejected");

 }

 

 } catch (AssertionError e) {

 test.log(Status.FAIL, "Credential mismatch test failed: " + e.getMessage());

 captureScreenshotOnFailure();

 throw e;

 } catch (Exception e) {

 test.log(Status.FAIL, "Credential mismatch test error: " + e.getMessage());

 captureScreenshotOnFailure();

 Assert.fail("Test failed: " + e.getMessage());

 }

 }

 

 @Test(priority = 6)

 public void testEmptyFields() {

 test = extent.createTest("Empty Fields Test");

 test.log(Status.INFO, "Testing empty email and password fields");

 

 try {

 // Test empty email - Using page object methods

 loginPage.enterEmail("");

 loginPage.enterPassword("somepassword");

 loginPage.clickLoginButton();

 

 Thread.sleep(2000);

 

 boolean loginSucceeded = loginPage.isLoggedIn();

 Assert.assertFalse(loginSucceeded, "Login should fail with empty email");

 

 // Test empty password - Using page object methods

 driver.navigate().refresh();

 Thread.sleep(1000);

 

 loginPage.enterEmail("test@example.com");

 loginPage.enterPassword("");

 loginPage.clickLoginButton();

 

 Thread.sleep(2000);

 

 loginSucceeded = loginPage.isLoggedIn();

 Assert.assertFalse(loginSucceeded, "Login should fail with empty password");

 

 test.log(Status.PASS, "Empty fields correctly rejected");

 

 } catch (AssertionError e) {

 test.log(Status.FAIL, "Empty fields test failed: " + e.getMessage());

 captureScreenshotOnFailure();

 throw e;

 } catch (Exception e) {

 test.log(Status.FAIL, "Empty fields test error: " + e.getMessage());

 captureScreenshotOnFailure();

 Assert.fail("Test failed: " + e.getMessage());

 }

 }

 

 

 private boolean isValidEmailFormat(String email) {

 return email != null && 

 email.contains("@") && 

 email.contains(".") && 

 !email.equals("invalid-email") &&

 !email.equals("user@invalid") &&

 !email.equals("@missing-local.com") &&

 !email.equals("missing-at-sign.com") &&

 !email.equals("invalid@email") &&

 !email.equals("invalid@.com") &&

 !email.equals("invalid-signup-email");

 }

 

 

 private boolean isPasswordStrong(String password) {

 if (password == null || password.length() < 6) {

 return false;

 }

 

 boolean hasNumbers = password.matches(".*\\d.*");

 boolean hasLetters = password.matches(".*[a-zA-Z].*");

 boolean hasSpecialChars = password.matches(".*[@#$%^&*].*");

 

 return hasNumbers && hasLetters && hasSpecialChars;

 }

 

 

 private void captureScreenshotOnFailure() {

 try {

 String screenshotPath = ScreenshotUtilities.capturescreen(driver, "Failed_Test");

 test.addScreenCaptureFromPath(screenshotPath);

 } catch (IOException e) {

 test.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());

 }

 }

}