package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionsWithFindElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://freshworks.com");
		Thread.sleep(2000);
		
		List<WebElement> footerFirstList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));

		//Iterate through this list
		for(int i=0; i<footerFirstList.size(); i++) {
			footerFirstList.get(i).click();
			
			//Exception is fired the second time, the click is attempted
			//Exception in thread "main" org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document

			//Can be Fixed by
			footerFirstList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		}
	}

}
