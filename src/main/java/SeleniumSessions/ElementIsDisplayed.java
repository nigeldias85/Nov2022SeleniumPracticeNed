package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisplayed {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a WebElement: need a locator
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		boolean imgIsDisplayed = driver.findElement(By.className("img-responsive")).isDisplayed();
		System.out.println("ImageIsDisplayed: "+imgIsDisplayed);
		if(imgIsDisplayed)
			System.out.println("PASS");
		else 
			System.out.println("FAIL");
		
		
		boolean searchTextbox = driver.findElement(By.name("search")).isDisplayed();
		System.out.println("SearchTextBoxIsDisplayed: "+searchTextbox);
		if(searchTextbox) {
			driver.findElement(By.name("search")).sendKeys("macbook");
			System.out.println("PASS");
		}
		else 
			System.out.println("FAIL");
		
		By logoImage = By.className("img-responsive");
		System.out.println(isElementDisplayed(logoImage));
		if(isElementDisplayed(logoImage))
			System.out.println("Logo Image is Present -- Pass");
		
		By searchField = By.name("search");
		By searchButton = By.cssSelector("#search > span > button");
		System.out.println(isElementDisplayed(searchField));
		if(isElementDisplayed(searchField)) {
			System.out.println("Search Field is Present -- Pass");
			doSendKeys(searchButton, "macbook");
			doClick(searchButton);
		}

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
