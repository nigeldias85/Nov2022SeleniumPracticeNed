package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TotalImages {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a WebElement: need a locator
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		System.out.println(imageList.size());
		
		int count=0;
		for(WebElement ele: imageList) {
			if(ele.getAttribute("alt").length() > 0) {
				count++;
				System.out.println(count +" : "+ele.getAttribute("alt"));
			}
		}
		
		//FE Versus FES
		//WebElement  | List of WebElements
		//NSE Exception | Return Empty list with size 0
		//Perform Action | No Action can be performed
	}

}
