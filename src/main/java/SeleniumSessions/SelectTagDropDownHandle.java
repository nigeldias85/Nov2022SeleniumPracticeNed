package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTagDropDownHandle {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By countryLocator = By.id("Form_getForm_Country");
		//dropdown => html tag --> select
		//Use select class in selenium
		
		WebElement countryWebElement = driver.findElement(countryLocator);
		Select select = new Select(countryWebElement);
		
		//Select by index
		//select.selectByIndex(45);
		
		//Select by value
		//select.selectByValue("Canada"); //Use the value attribute
		
		//Select by visible text
		//select.selectByVisibleText("France"); //Use the text of the option tag
		
		//Select country 55
		doSelectDropDownByIndex(countryLocator, 55);
		Thread.sleep(3000);
		
		//Select Canada
		doSelectDropDownByValue(countryLocator, "Canada");
		Thread.sleep(3000);
		
		//Select France
		//doSelectDropDownByVisibleText(countryLocator, "France111"); 
		//If this element is not present , then NoSuchElement Exception is thrown.
		//Cannot locate option with text: France111
		doSelectDropDownByVisibleText(countryLocator, "France"); 
		Thread.sleep(3000);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

}
