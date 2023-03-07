package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisableTextFieldEnterValue {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		Thread.sleep(2000);
		
		
		WebElement passwordEle = driver.findElement(By.id("pass"));
		
		//EXCEPTION is fired for the below line
		//Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: element not interactable
		//passwordEle.sendKeys("Welcome@123");
		
		
		//Try clicking a disabled button
		//An Exception is fired as: ElementClickInterceptedException
		

	}

}
