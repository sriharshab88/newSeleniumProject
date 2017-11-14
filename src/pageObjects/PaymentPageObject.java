package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class PaymentPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public PaymentPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickBankWireMethod() throws Exception {
		 
		genericMethods.clickByXpath("//a[@class='bankwire']", "FAIL -- The BankWire payment method is not found");
		results.log("The BankWire payment method is found", true);
	}
	
}


