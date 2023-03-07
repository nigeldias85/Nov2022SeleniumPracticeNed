package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsInSelenium {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//8 Locators in Selenium
		//id, name, className
		//xpath , cssSelector
		//linkText , partialLinkText
		//tagName
		
		//Create a WebElement: need a locator
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1.ID Locator - Unique Attribute
		//driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
		
		//2. Name locator - Name can be duplicate
		//driver.findElement(By.name("email")).sendKeys("naveen@gmail.com");
		//By emailLocator = By.name("email");
		
		
		//3. Class Name locator - Can be duplicate most of the time
		//Multiple web elements on the page can have the same classname
		//Use class name only if it is unique.
		//driver.findElement(By.className("form-control")).sendKeys("naveen@gmail.com");
		
		//4. xpath: Its not an attribute. It is the address of the element in the html DOM.
		ElementUtil elementUtil = new ElementUtil(driver);
		//driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("naveen@gmail.com");
		By emailIdLocator = By.xpath("//*[@id='input-email']");
		//doSendKeys(emailIdLocator, "naveen@gmail.com");
		elementUtil.doSendKeys(emailIdLocator, "naveen@gmail.com");
		//driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("welcome@123");
		By passwordLocator = By.xpath("//*[@id='input-password']");
		//doSendKeys(passwordLocator, "welcome@123");
		elementUtil.doSendKeys(passwordLocator, "welcome@123");
		//driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input")).click();
		By buttonLocator = By.xpath("//*[@id='content']/div/div[2]/div/form/input");
		//doClick(buttonLocator);
		elementUtil.doClick(buttonLocator);
		
		//5. css selector - This is not an attribute
		//driver.findElement(emailIdLocator).clear();
		//driver.findElement(passwordLocator).clear();
		//driver.findElement(By.cssSelector("#input-email")).sendKeys("naveen@gmail.com");
		//driver.findElement(By.cssSelector("#input-password")).sendKeys("welcome@123");
		//driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		
		
		//6. linktext - Only for links - htmltag => a , linktext can be duplicate
		//This is not an attribute - It is the text of the link
		//driver.findElement(By.linkText("Register")).click();
		By registerLinkLocator = By.linkText("Register");
		elementUtil.doClick(registerLinkLocator);
		
		
		//7. partialLinkText
		//This is not an attribute - It is the partial text of the link
		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8. Tag name => html tag
		By loginLinkLocator = By.linkText("Login");
		elementUtil.doClick(loginLinkLocator);
		//String textvalue = driver.findElement(By.tagName("h2")).getText();
		//System.out.println("TEXT: "+textvalue);
		By tagNameLocator = By.tagName("h2");
		String textValue = elementUtil.doElementGetText(tagNameLocator);
		System.out.println("TEXT: "+textValue);
		
		//getText() => Use Cases for links, headers, paragraphs
		By paymentLocator = By.linkText("Recurring payments");
		System.out.println(elementUtil.doElementGetText(paymentLocator));
		
		//UseCase for click: buttons, links, checkboxes and radiobuttons
		//UseCase for sendKeys: textboxes/textareas , dropdown , fileupload

	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		WebElement element = getElement(locator);
		element.click();
	}
	
	public static void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.sendKeys(value);
	}
	
	public static String  doElementGetText(By locator) {
		WebElement element =  getElement(locator);
		return element.getText();
		
	}
	
}
