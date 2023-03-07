package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(2000);

		WebElement emailWebEle = driver.findElement(By.id("input-email"));
		emailWebEle.sendKeys("naveen@gmail.com");
		
		driver.navigate().refresh();
		emailWebEle = driver.findElement(By.id("input-email"));
		
		//The below line gives the exception as:
		//Exception in thread "main" org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
		//The is fired since, the input value is set after the page has been refreshed
		emailWebEle.sendKeys("gurjeet@gmail.com");
		
	}

}
