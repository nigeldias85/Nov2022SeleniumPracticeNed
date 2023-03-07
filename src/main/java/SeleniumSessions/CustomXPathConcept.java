package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPathConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
		//xpath - Address of the element in the html DOM
		//1. Absolute Xpath -- /html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/h4/a
		//2. Relative Xpath: Custom Xpath
		
		//For eg: Email Address field on login page
		//tag[@attr='value']
		//input[@name='email']
		//input[@placeholder='E-Mail Address']
		
		//tag[@attr1='value1' and @attr2='value2']
		
		//input[@type='text' or @type='text']
		
		//Check with text
		//text() is not an attribute, it is a function
		//tag[text()='<value>']
		//h2[text()='New Customer']
		
		By MyAccLocator = By.xpath("//a[text()='My Account']");
		System.out.println(driver.findElements(MyAccLocator).size());
		
		//text() with attribute
		
		//contains() with attribute
		//tag[contains(@attr, <value>)]
		//input[contains(@placeholder, 'E-Mail')]
		
		//Contains with one attribute and use another contains() without attribute
		//tag[contains(@attr1, <value>) and @attr2='<value>']
		//input[contains(@placeholder, 'E-Mail') and @name='email']
		
		//Dynamic ID/attribute
		//input[contains(@id, 'FirstName_')]
		
		//contains: using text() with contains
		//p[contains(text() , 'marketing, sales, support')]
		
		//Get all links from the amazon.com which have the string Amazon
		//a[contains(text(), 'Amazon')]
		
		//Contains with text() and attribute
		//tag[contains(text(), 'value') and @attr='value']
		//Contains with text() and Contains with attribute
		//a[contains(text(), 'Science') and contains(@href, 'science')]
		
		//Contains with text() and Contains without attribute
		//a[contains(text(), 'Science') and @class='nav_a']
		
		//Starts-With
		//tag[starts-with(text(), 'value')]
		//small[starts-with(text(), 'Our deal tracking tool')]
		
		//ends-with is not available -- NA
		
		//input[starts-with(@aria-labelledby, 'UIFormControl') and @type='email']
		
		
		
		//Position/Index in xpath
		By emailAddressLocator = By.xpath("(//input[@class='form-control'])[1]");
		By passwordLocator = By.xpath("(//input[@class='form-control'])[2]");
		
		By emailAddLocatorUsingPos = By.xpath("(//input[@class='form-control'])[position()=1]");
		By passwordLocatorUsingPos = By.xpath("(//input[@class='form-control'])[position()=2]");
		
		By passwordLocatorUsingLast = By.xpath("(//input[@class='form-control'])[last()]");
		
		
		//Login to amazon.com
		//Get xpath for help
		By helpLocator = By.xpath("((//div[contains(@class, 'navFooterLinkCol')])[last()]//a)[last()]");
		
		//Get xpath for amazon assitant
		By amzAssistantLocator = By.xpath("((//div[contains(@class, 'navFooterLinkCol')])[last()]//a)[last() -1]");
		
		
		//Class in locator: classname, xpath, css selector
		//Go to app.hubspot.com/login
		By usernameLocator = By.xpath("//input[@class='form-control private-form__control login-email']");
		By usernameLocatorNew = By.xpath("//input[@class='form-control']"); //This is not classname
		
		//This is NOT VALID -- Only one class is allowed
		By usernameLocatorUsingClassName = By.className("form-control private-form__control login-email"); 
		By usernameLocatorUsingClassNameNew = By.className("form-control"); // This is VALID
		
		//This is VALID and allowed
		By usernameLocatorUsingXpath = By.xpath("//input[contains(@class, 'login-email')]");
		
		//Parent to child
		//	Parent/Child --> Direct
		//	Parent//Child --> Indirect
		
		//Child to Parent
		
		//	//input[@id='input-email']/../..
		
		//Go to previous sibling
		//input[@id='input-email']/preceding-sibling::label
		
		//Go to next sibling
		//label[@for='input-email']/following-sibling::input
		//label[@for='input-email']/following-sibling::input[@name='email']
		
		//Get xpath in cricinfo
		//span[text()='Jordan Hermann']/parent::span/parent::a/parent::td/following-sibling::td/span/span
		
		
		//*[@id='input-firstname']
		
		
		

	}

}
