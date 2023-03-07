package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotPresent {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a WebElement: need a locator
				driver = new ChromeDriver();
				driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
				
				By logoImage = By.className("img-responsive123");
				By searchField = By.name("search");
				
				//Create Web Element + Action
				boolean imgDisplayed = driver.findElement(logoImage).isDisplayed();
				System.out.println(imgDisplayed);
				//findElement gives NoSuchElementException

	}

}
