package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a Web Element and perform some action(Click, sendKeys, getText, isDisplayed...)
		
		
		//Create a WebElement: need a locator
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1. Locator : id
		//1st Approach
		//driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("welcome123");

		
		//2nd Approach
		//WebElement emailAddress = driver.findElement(By.id("input-email"));
		//WebElement password = driver.findElement(By.id("input-password"));
		
		//emailAddress.sendKeys("naveen@gmail.com");
		//password.sendKeys("welcome1");
		
		//3rd By Locator
		//By emailAddressLocator = By.id("input-email");
		//By passwordLocator = By.id("input-password");
		
		//WebElement mailId = driver.findElement(emailAddressLocator);
		//WebElement password = driver.findElement(passwordLocator);
		
		//mailId.sendKeys("naveen@gmail.com");
		//password.sendKeys("welcome123");
		
		//4th Approach: By Locator + Generic Method
		//By emailAddressLocator = By.id("input-email");
		//By passwordLocator = By.id("input-password");
		
		//getElement(emailAddressLocator).sendKeys("naveen@gmail.com");
		//getElement(passwordLocator).sendKeys("welcome123");
		
		//5th Approach: By locator + generic method for getElement and actions
		//By emailAddressLocator = By.id("input-email");
		//By passwordLocator = By.id("input-password");
		//doSendKeys(emailAddressLocator, "naveen@gmail.com");
		//doSendKeys(passwordLocator, "welcome123");
		
		
		//6th Approach: By Locator + generic method for WebElement and  Actions in a Element Util class
		By emailAddressLocator = By.id("input-email");
		By passwordLocator = By.id("input-password");
		
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(emailAddressLocator, "naveen@gmail.com");
		elementUtil.doSendKeys(passwordLocator, "welcome123");
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

}
