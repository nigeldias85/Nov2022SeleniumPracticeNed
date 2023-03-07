package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(4000);
		
		//SVG Element
		//Scaler
		//Vector
		//Graph
		
		//Switch to a Frame
		WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@id, 'map-instance')]"));
		driver.switchTo().frame(frameElement);
		
		String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']"; 
		List<WebElement> svgEleStatesList = driver.findElements(By.xpath(svgXpath));
		System.out.println("Size: "+svgEleStatesList.size());
		
		//Iterate and print
		for(WebElement eleState: svgEleStatesList) {
			String stateName = eleState.getAttribute("name");
			System.out.println("StateValue: "+stateName);
			
			if(stateName.equals("Wyoming")) {
				eleState.click();
				
				//Get all the counties in Wyoming
				System.out.println("");
				System.out.println("");
				System.out.println("----------------------");
				String wyomingCountyPath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @id='wyoming']//*[name()='g' and @class='subregion']//*[name()='path']";
				List<WebElement> wyomingCountyList = driver.findElements(By.xpath(wyomingCountyPath));
				System.out.println("Size: "+wyomingCountyList.size());
				
				//Iterate through all the counties in Wyoming and print them
				for(WebElement eleWymCnty: wyomingCountyList) {
					String countyName = eleWymCnty.getAttribute("name");
					System.out.println("CountyName: "+countyName);
				}
				
			}
		}
	}

}
