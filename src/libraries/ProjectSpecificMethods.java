package libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

/**
 * This class file consists of all methods which are related to this project only.
 * @author Sri harsha
 */
public class ProjectSpecificMethods {


	WebDriver driver;
	WebDriverWait wait;
	HomePageObject homepage;
	LoginPageObject loginpage;
	
	
	public ProjectSpecificMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		homepage = new HomePageObject(driver, wait);
		loginpage = new LoginPageObject(driver, wait);
	}
	

	/**
	 * This method scrolls the page based on the co-ordinates provided
	 * @param upCordinate
	 * @param downCordinate
	 * @throws Exception 
	 */
	public void pageScroll(String upCordinate, String downCordinate) throws Exception {
		
		try {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy("+upCordinate+","+downCordinate+")", "");
		}catch (Exception e) {
			throw new Exception("FAIL -- Page did not scroll");
		}
	}
	
	public void signIn(String emailId, String password) throws Exception {
		
		homepage.clickSignInLink();
		loginpage.enterUsername(emailId);
		loginpage.enterPassword(password);
		loginpage.clickSignInButton();
	}
	
}
