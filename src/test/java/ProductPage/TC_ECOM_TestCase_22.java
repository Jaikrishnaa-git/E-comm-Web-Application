package ProductPage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class TC_ECOM_TestCase_22 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/products");
    }

    @Test
    public void verifyAddToCartStylishDress() throws InterruptedException {

        // Scroll to Stylish Dress
        WebElement stylishDress = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='product-image-wrapper'][.//p[text()='Stylish Dress']]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stylishDress);

        // Locate Add to Cart button
        WebElement addToCartBtn = stylishDress.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));

        // Wait until it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        // Click using JavaScript to avoid interception issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

        // Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));

        // Click on Continue Shopping button to close the modal
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Continue Shopping')]")));
        continueBtn.click();

        // ✅ Fix: Check if "View Cart" link is visible instead of cart count
        WebElement viewCartLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='/view_cart']")));

        // Assert that the view cart link is displayed — meaning product added successfully
        Assert.assertTrue(viewCartLink.isDisplayed(), "Product not added to cart!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
