package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLocator {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(2000);
		
		//Below line gives the exception as:
		//Exception in thread "main" org.openqa.selenium.InvalidSelectorException: invalid selector: Unable to locate an element with the xpath expression //////input[@@@id='name'] because of the following error:
		//SyntaxError: Failed to execute 'evaluate' on 'Document': The string '//////input[@@@id='name']' is not a valid XPath expression.
		//Here XPATH is syntax wise completely INVALID
		//driver.findElement(By.xpath("//////input[@@@id='name']")).sendKeys("Testing");
		
		//Below line gives the exception as:
		//Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//input[@id='namenigel']"}
		
		//Here XPATH is having VALID syntax , but the attribute is INVALID
		//driver.findElement(By.xpath("//input[@id='namenigel']")).sendKeys("Testing");
		
		//EXCEPTIONS
		//If alert is not present, then
		//NoAlertException
		
		//If frame is not present, then
		//NoFramePresentException
		
		//If new window not present, then
		//NoWindowPresentException

	}

}
