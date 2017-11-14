package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to Home page of the application
 * @author Sri harsha
 */
public class HomePageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public HomePageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}

	public void clickSignInLink() throws Exception {
		
		genericMethods.clickByXpath("//a[@class='login']", "FAIL -- Sign link is not found");
		results.log("Sign link is found", true);
	}
	
	public void clickLogo() throws Exception {	
		genericMethods.clickByXpath("//img[@alt='My Store']", "FAIL -- Logo not found");
		results.log("Logo Found", true);
	}
	
	public void clickUserNameAccount() throws Exception {
		
		genericMethods.clickByXpath("//a[@class='account']", "FAIL -- Username Account tab not found");
		results.log("Username Account tab not found", true);
	}
	
	public void waitForProductSection() throws Exception {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='center_column']")));
		results.log("Product Section found", true);
	}

}
