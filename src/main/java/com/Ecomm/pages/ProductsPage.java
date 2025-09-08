package com.Ecomm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productsLink = By.xpath("//a[@href='/products']");
    private final By firstProductAddBtn = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private final By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By womensDropDown = By.xpath("//a[@href='#Women']");
    private final By mensDropDown = By.xpath("//a[@href='#Men']");
    private final By kidsDropDown = By.xpath("//a[@href='#Kids']");
    private final By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
    private final By HmBrand = By.xpath("//a[@href='/brand_products/H&M']");
    private final By madameBrand = By.xpath("//a[@href='/brand_products/Madame']");
    private final By mastBrand = By.xpath("//a[@href='/brand_products/Mast & Harbour']");
    private final By babyHugBrand = By.xpath("//a[@href='/brand_products/Babyhug']");
    private final By allenBrand = By.xpath("//a[@href='/brand_products/Allen Solly Junior']");
    private final By kookieKidsBrand = By.xpath("//a[@href='/brand_products/Kookie Kids']");
    private final By bibaBrand = By.xpath(" //a[@href='/brand_products/Biba']");
    private final By product1 = By.xpath("//a[@href='/product_details/1']");
    private final By quantity = By.xpath("//input[@id='quantity']");
    private final By addToCart = By.xpath("//a[@data-product-id='1']");
    
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void openProducts() {
        driver.get("https://www.automationexercise.com/products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductAddBtn));
    }
    
    public void openProductpage()
    {
     	driver.findElement(productsLink).click();
    }
  
    public void addFirstProductToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(firstProductAddBtn));

     
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);

       
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);

       
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
            continueBtn.click();
        } catch (Exception e) {

        }
    }
    
    public boolean verifyDropDown()
    {
    	 return driver.findElement(womensDropDown).isDisplayed() && driver.findElement(mensDropDown).isDisplayed() && driver.findElement(kidsDropDown).isDisplayed();
    }


	public boolean verifyBrands() {
		
		return false;
	}


	public boolean isBrandVisible() {
		
		
		return driver.findElement(poloBrand).isDisplayed(); //&&
//				driver.findElement(HmBrand).isDisplayed() &&
//				driver.findElement(madameBrand).isDisplayed() &&
//				driver.findElement(mastBrand).isDisplayed() &&
//				driver.findElement(babyHugBrand).isDisplayed() && 
//				driver.findElement(allenBrand).isDisplayed() &&
//				driver.findElement(kookieKidsBrand).isDisplayed() &&
//				driver.findElement(bibaBrand).isDisplayed();
	}
	public void clickProduct()
	{
		 driver.findElement(product1).click();
	}
	public boolean clickProduct2() throws InterruptedException
	{
		 driver.findElement(product1).click();
		 Thread.sleep(2000);
		return driver.findElement(quantity).isDisplayed();
	}
	public boolean cartVisible()
	{
		return driver.findElement(addToCart).isDisplayed();
	}
	
}
