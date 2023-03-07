package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUseCases {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		By linksLocator = By.tagName("a");
		if(getTotalElementsCount(linksLocator)>250) {
			System.out.println("All links Loaded--Pass");
		}
		else {
			System.out.println("All links Not Loaded--Fail");
		}
	}
	
	public static int getTotalElementsCount(By locator) {
		int eleCount = getElements(locator).size();
		System.out.println("ElementCountFor: "+locator+" ---> "+eleCount);
		return eleCount;
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
