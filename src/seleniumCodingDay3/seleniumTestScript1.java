package seleniumCodingDay3;

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
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class seleniumTestScript1 {
	
	@Test
	public void webDriverCommands() {

		if (System.getProperty("os.name").equals("windows")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver");

		}

		WebDriver driver = new FirefoxDriver(); // This will launch Firefox browser
		driver.get("http://automationpractice.com/index.php"); // This will launch the application

		System.out.println("This is the current URL -->" + driver.getCurrentUrl()); // Print the url of the page.
		System.out.println("This is the Window title -->" + driver.getTitle()); // Print the title of the page.
		driver.manage().window().maximize(); // Maximize the browser window

		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); // Will identify the sign in link
																						// and stores
		signInLink.click(); // Clicks the sign in link

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation88@test.com"); // Enter the
																									// username in email
																									// text field
		WebElement password = driver.findElement(By.id("passwd")); // Identifies password web element and stores
		password.sendKeys("123456"); // Enters text into the password field
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click(); // clicks on submit button

		// driver.close(); //close the browser
		driver.quit(); // Quit the Service and all opened instances of the browser

	}

	@Test
	public void webDriverCommands2() throws InterruptedException {

		if (System.getProperty("os.name").equals("windows")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver");
		}

		WebDriver driver = new FirefoxDriver(); // This will launch Firefox browser
		driver.get("http://automationpractice.com/index.php"); // This will launch the application

		driver.manage().window().maximize(); // Maximize the browser window

		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); // Will identify the sign in link
																						// and stores
		signInLink.click(); // Clicks the sign in link

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation88@test.com"); // Enter the
																									// username in email
																									// text field
		WebElement password = driver.findElement(By.id("passwd")); // Identifies password web element and stores
		password.sendKeys("123456"); // Enters text into the password field
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click(); // clicks on submit button

		driver.findElement(By.xpath("//img[@alt='My Store']")).click(); // click the homepage logo
		WebDriverWait wait = new WebDriverWait(driver, 30); // creating webdriver wait instance

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='center_column']"))); // waiting
		
		driver.findElement(By.xpath("//a[@class='account']")).click();

		String accountPageText = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();

		Assert.assertEquals(accountPageText, "MY ACCOUNT", "FAIL -- The account page text is not displayed properly");

		driver.findElement(By.xpath("//a[@title='Orders']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'DHZQDWAXX')]")).click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@class,'button btn btn-default')]")));

		driver.findElement(By.xpath("//a[contains(@class,'button btn btn-default')]")).click();

		String product = driver.findElement(By.xpath("//p[@class='product-name']/a")).getText();

		// Assert.assertEquals(product, "Faded Short Sleeve T-shirts", "FAIL -- Product
		// does not match");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,900)", "");

		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		driver.findElement(By.xpath("//div[@id='uniform-cgv']")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		driver.findElement(By.xpath("//p[@id='cart_navigation']/button")).click();

		String confirmation = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();
		Assert.assertEquals(confirmation, "ORDER CONFIRMATION", "FAIL -- Order not confirmed");

		driver.quit();
	}
	
	@Test
	public void webdriverCommands3() throws InterruptedException {
		
		if (System.getProperty("os.name").equals("windows")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "geckodriver");
		}

		WebDriver driver = new FirefoxDriver(); // This will launch Firefox browser
		driver.get("http://automationpractice.com/index.php"); // This will launch the application

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
		
		driver.quit();
		
		
		
	}
	
	
	//test comment added by Chenlin Zhong
	@Test
	public void testMethod(){
		
		System.out.println("hello ");
	}

}
