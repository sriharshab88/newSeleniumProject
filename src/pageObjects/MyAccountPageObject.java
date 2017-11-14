package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to My Account page of the application
 * @author Sri harsha
 */
public class MyAccountPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public MyAccountPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public String getMyAccountText() throws Exception {
		 
		String result = genericMethods.getTextByXpath("//div[@id='center_column']/h1", "FAIL -- The account page text is not found");
		results.log("The account page text is found", true);
		return result;
	}
	
	public void clickOrderLink() throws Exception {
		 
		genericMethods.clickByXpath("//a[@title='Orders']", "FAIL -- The Order link is not found");
		results.log("The Order link is found", true);
	}

	public void clickOnSubmittedOrder() throws Exception {
		 
		genericMethods.clickByXpath("//a[contains(text(),'DHZQDWAXX')]", "FAIL -- The Submitted Order link is not found");
		results.log("The Submitted Order link is found", true);
	}
	
	public void clickOnReOrderButton() throws Exception {
		 
		genericMethods.clickByXpath("//a[contains(@class,'button btn btn-default')]", "FAIL -- The Re Order button is not found");
		results.log("The Re Order button is found", true);
	}
}


