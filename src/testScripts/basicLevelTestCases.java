package testScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import libraries.ProjectSpecificMethods;
import libraries.Utilities;
import pageObjects.AddressPageObject;
import pageObjects.CartSummaryPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.OrderConfirmationPageObject;
import pageObjects.OrderSummaryPageObject;
import pageObjects.PaymentPageObject;
import pageObjects.ShippingPageObject;
import results.ExtentResults;
import testData.TestDataReader;




/**
 * This file has the test scripts for the basic functionalities of demo application
 * @author Sri harsha
 */
public class basicLevelTestCases {
	
	WebDriver driver;
	WebDriverWait wait;
	ProjectSpecificMethods projectSpecificMethods;
	HomePageObject homepage;
	LoginPageObject loginpage;
	MyAccountPageObject myAccountPage;
	CartSummaryPageObject cartSummaryPageObject;
	AddressPageObject addressPageObject;
	ShippingPageObject shippingPageObject;
	PaymentPageObject paymentPageObject;
	OrderSummaryPageObject orderSummaryPageObject;
	OrderConfirmationPageObject orderConfirmationPageObject;
	Utilities utilities = new Utilities();
	ExtentResults results = new ExtentResults();
	
	@BeforeTest
	public void startBrowser() {
		driver = utilities.launchBrowser();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize(); // Maximize the browser window
		projectSpecificMethods = new ProjectSpecificMethods(driver, wait);
		homepage = new HomePageObject(driver, wait);
		loginpage = new LoginPageObject(driver, wait);
		myAccountPage = new MyAccountPageObject(driver, wait);
		cartSummaryPageObject = new CartSummaryPageObject(driver, wait);
		addressPageObject = new AddressPageObject(driver, wait);
		shippingPageObject = new ShippingPageObject(driver, wait);
		paymentPageObject = new PaymentPageObject(driver, wait);
		orderSummaryPageObject = new OrderSummaryPageObject(driver, wait);
		orderConfirmationPageObject = new OrderConfirmationPageObject(driver, wait);
	}
	
	@Test
	public void demoLoginTest() throws Exception {

		results.createTestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), 
				this.getClass().getSimpleName());
		Reporter.log("This is the current URL -->" + driver.getCurrentUrl(), true); // Print the url of the page.
		Reporter.log("This is the Window title -->" + driver.getTitle(), true); // Print the title of the page.

		projectSpecificMethods.signIn(TestDataReader.email, TestDataReader.password);
	
	}

	@Test
	public void demoReorderTest() throws Exception {
		
		results.createTestcase(Thread.currentThread().getStackTrace()[1].getMethodName(), 
				this.getClass().getSimpleName());

		projectSpecificMethods.signIn(TestDataReader.email, TestDataReader.password);

		homepage.clickLogo();
		homepage.waitForProductSection();
		homepage.clickUserNameAccount();
		
		String accountPageText = myAccountPage.getMyAccountText();
		results.assertEquals(accountPageText, TestDataReader.myAccountText, 
				TestDataReader.myAccountValidationMessage);
		
		myAccountPage.clickOrderLink();
		myAccountPage.clickOnSubmittedOrder();
		myAccountPage.clickOnReOrderButton();
		
		//String product = cartSummaryPageObject.getProductNameText();
		// Assert.assertEquals(product, "Faded Short Sleeve T-shirts", "FAIL -- Product
		// does not match");

		projectSpecificMethods.pageScroll("0", "900");
		
		cartSummaryPageObject.clickProceedToCheckoutButton();
		addressPageObject.clickProceesAddressButton();
		shippingPageObject.clickTosCheckbox();
		shippingPageObject.clickProcessCarrierButton();
		paymentPageObject.clickBankWireMethod();
		orderSummaryPageObject.clickConfirmOrderButton();

		String confirmation = orderConfirmationPageObject.getOrderConfirmationMessage();
		results.assertEquals(confirmation, TestDataReader.orderConfirmationText, 
				TestDataReader.orderConfirmationTextValidationMessage);

	}
	
	@Test
	public void demoSelectDropDownTest() throws InterruptedException {
		
		driver.manage().window().maximize(); // Maximize the browser window

		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); // Will identify the sign in link
																						// and stores
		signInLink.click(); // Clicks the sign in link
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("newemailtestaccount01@test.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='account-creation_form']")));
		
		String accountPage = driver.findElement(By.xpath("//div[@id='noSlide']/h1")).getText();
		Assert.assertEquals(accountPage, "CREATE AN ACCOUNT", "FAIL -- Account page title does not match");
		
		//Scroll the page down
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,250)", "");
		
		//Selenium commands for drop down selection
		
		WebElement dateDropdown = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateDD = new Select(dateDropdown);
		dateDD.selectByIndex(8);    // Date as 8
		
		WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthDD = new Select(monthDropdown);
		monthDD.selectByValue("7");   //Month as July
		
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearDD = new Select(yearDropdown);
		yearDD.selectByVisibleText("1988  ");   //Year as 1988
		
	}
	
	@Test
	public void testMethod(){
		
		System.out.println("hello ");

	}
	
	//@Test(dataProviderClass=TestData.class, dataProvider = "getSearchTestData")
	public void emailIDValidations() {
		
		
	}
	@AfterTest
	public void endBrowser(){
		// driver.close(); //close the browser
		driver.quit(); // Quit the Service and all opened instances of the browser
	}
		
	
}
