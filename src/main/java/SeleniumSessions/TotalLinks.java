package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a WebElement: need a locator
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		//Get all links
		//Print total link count
		//Print text for all links
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("LinksCount: "+linksList.size());
		System.out.println("");
		int count=0;
		for(WebElement ele: linksList) {
			
			if(ele.isDisplayed() && ele.getText().length() > 0) {
				count++;
				System.out.println(count +" : "+ele.getText());
			}
		}
		System.out.println("");
		System.out.println(count);
		System.out.println("BlankTextCount: "+(linksList.size() - count));
		

	}

}
