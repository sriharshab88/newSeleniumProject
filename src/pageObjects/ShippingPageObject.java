package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class ShippingPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public ShippingPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickTosCheckbox() throws Exception {
		 
		genericMethods.clickByXpath("//div[@id='uniform-cgv']", "FAIL -- The TOS checkbox is not found");
		results.log("The TOS checkbox is found", true);
	}
	
	public void clickProcessCarrierButton() throws Exception {
		 
		genericMethods.clickByXpath("//button[@name='processCarrier']", "FAIL -- The Process Carrier button is not found");
		results.log("The Process Carrier button is found", true);
	}
}


