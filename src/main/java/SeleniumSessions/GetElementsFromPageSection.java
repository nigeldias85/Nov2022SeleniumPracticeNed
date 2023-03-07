package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElementsFromPageSection {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By listGroupLinkLocator = By.xpath("//aside[@id='column-right']//a");
//		List<WebElement> focusedLinksList =  driver.findElements(listGroupLinkLocator);
//		System.out.println("Size: "+focusedLinksList.size());
		
//		for(WebElement ele: focusedLinksList) {
//			System.out.println("LinkText: "+ele.getText());
//		}
		
		List<String> linksTextList = getElemntsTextList(listGroupLinkLocator);
		System.out.println("Size: "+linksTextList.size());
		System.out.println(linksTextList);
		
		System.out.println("----------------------");
		By footerLinksGroupLocator = By.xpath("//footer/div[@class='container']//a");
		linksTextList = getElemntsTextList(footerLinksGroupLocator);
		System.out.println("Size: "+linksTextList.size());
		System.out.println(linksTextList);
	}
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getElemntsTextList(By locator) {
		List<WebElement> elementList =   getElements(locator);
		List<String> elementTextList = new ArrayList<String>();
		for(WebElement ele: elementList) {
			elementTextList.add(ele.getText());
		}
		return elementTextList;
	}

}
