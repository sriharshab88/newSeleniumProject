package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to Login page of the application
 * @author Sri harsha
 *
 */
public class LoginPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	

	public LoginPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	
	public void clickSignInButton() throws Exception {
		genericMethods.clickByXpath("//button[@id='SubmitLogin']", "FAIL -- Sign in Button not found");
		results.log("Sign in Button found", true);
	}
	
	public void enterUsername(String username) throws Exception {
		genericMethods.enterByXpath("//input[@id='email']", username, 
				"FAIL -- Username text field not found");
		results.log("Username text field found", true);
	}
	
	public void enterPassword(String password) throws Exception {
		genericMethods.enterById("passwd", password, 
				"FAIL -- Password text field not found");
		results.log("Password text field found", true);
	}
}
