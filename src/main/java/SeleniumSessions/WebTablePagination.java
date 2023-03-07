package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTablePagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);

		//Build logic to select a single checkbox(SINGLE SELECTION)
//		String country = "Srilanka";
//		while(true) {
//			
//			if(driver.findElements(By.xpath("//td[text()='"+country+"']")).size() > 0) {
//				selectCountry(country);
//				break;
//			}
//			else {
//				//Click on next
//				WebElement next =driver.findElement(By.linkText("Next"));
//				//check for next button being disabled
//				if(next.getAttribute("class").contains("disabled")) {
//					System.out.println("Pagination is over.Country not found.");
//					break;
//				}
//				next.click();
//				Thread.sleep(1000);
//			}
//		}
		
		
		//Build logic for multiple selections
		String multiSelectCountry = "United States";
		while(true) {
			List<WebElement> countryList = driver.findElements(By.xpath("//td[text()='"+multiSelectCountry+"']"));
			if(countryList.size() > 0) {
				selectMultipleCountry(multiSelectCountry);
			}
			
			//Pagination logic
			//Click on next
			WebElement next =driver.findElement(By.linkText("Next"));
			//check for next button being disabled
			if(next.getAttribute("class").contains("disabled")) {
				System.out.println("Pagination is over.Country not found.");
				break;
			}
			next.click();
			Thread.sleep(1000);
			
		}
		
	}
	
	
	public static void selectMultipleCountry(String countryName) {
		String xpath = "(//td[text()='"+countryName+"'])/preceding-sibling::td/input[@type='checkbox']";
		System.out.println("Xpath: "+xpath);
		List<WebElement> countryList = driver.findElements(By.xpath(xpath));
		Actions act = new Actions(driver);
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		for(WebElement ele: countryList) {
			try {
				ele.click();
			} catch (Exception e) {
				// TODO: handle exception
				//Get the first checkbox into view and then click using actions as ele.click() fails to click
				WebElement searchEle = driver.findElement(By.xpath("//label[text()='Search:']/input[@type='search']"));
				jsUtil.scrollIntoView(searchEle);
				
				//This does not work
				//Exception Fired
				//Exception in thread "main" org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="checkbox"> is not clickable at point (42, 123). Other element would receive the click: <div class="elementor-widget-wrap elementor-element-populated">...</div>
				//ele.click();
				
				//Click using actions class
				act.moveToElement(ele).click().build().perform();
			}
			
		}
	}
	
	
	public static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='"+countryName+"']/preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
