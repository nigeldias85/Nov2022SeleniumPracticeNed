package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(2000);
		
		//Build By locators
		By fn = By.id("input-firstname");
		By ln = By.id("input-lastname");
		By submitBtn = By.xpath("//input[@type='submit']");
		

//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(fn), "Nigel").build().perform();
//		act.sendKeys(driver.findElement(ln), "Dias").build().perform();
//		act.click(driver.findElement(submitBtn)).build().perform();
		
		//Above method of using Actions class to enter input values is used when there could be
		//ElementNotInteractableException
		//ElementNotInterceptableException
		
		doActionSendKeys(fn, "Nigel");
		doActionSendKeys(ln, "Dias");
		doActionsClick(submitBtn);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionSendKeys(By locator, String key) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), key).build().perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
}
