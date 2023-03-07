package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementAttributeConcept {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
		By firstNameLocator = By.name("firstname");
		//String phValue = driver.findElement(firstNameLocator).getAttribute("placeholder");
		String phValue = getElementAttribute(firstNameLocator, "placeholder");
		System.out.println("phValue: "+phValue);
		
		By logoLocator = By.className("img-responsive");
		//String source = driver.findElement(logoLocator).getAttribute("src");
		//String title = driver.findElement(logoLocator).getAttribute("title");
		String source = getElementAttribute(logoLocator, "src");
		String title = getElementAttribute(logoLocator, "title");
		System.out.println("Title: "+title);
		System.out.println("Source: "+source);

	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String getElementAttribute(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

}
