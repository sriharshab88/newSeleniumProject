package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class CartSummaryPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public CartSummaryPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public String getProductNameText() throws Exception {
		 
		String result = genericMethods.getTextByXpath("//p[@class='product-name']/a", "FAIL -- The Product name text is not found");
		results.log("The Product name text is found", true);
		return result;
		
	}

	public void clickProceedToCheckoutButton() throws Exception {
		 
		genericMethods.clickByXpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']", "FAIL -- The Proceed to Checkout button is not found");
		results.log("The Proceed to Checkout button is found", true);
	}
}


