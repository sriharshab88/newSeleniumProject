package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class OrderConfirmationPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public OrderConfirmationPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public String getOrderConfirmationMessage() throws Exception {
		 
		String result = genericMethods.getTextByXpath("//div[@id='center_column']/h1", "FAIL -- The Order confirmation message is not found");
		results.log("The Order confirmation message is found", true);
		return result;
	}
	
}


