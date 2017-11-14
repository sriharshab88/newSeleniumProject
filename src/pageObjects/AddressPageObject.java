package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class AddressPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public AddressPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public void clickProceesAddressButton() throws Exception {
		 
		genericMethods.clickByXpath("//button[@name='processAddress']", "FAIL -- The Procees Address button is not found");
		results.log("The Procees Address button is found", true);
	}
}


