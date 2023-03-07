package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFooterLinks {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		//Get footer links
		List<WebElement> footerElementsList = driver.findElements(By.xpath("//div[@jscontroller]/div/a"));
		System.out.println("The footer links are...");
		for(WebElement ele: footerElementsList) {
			if(ele.getText().length() > 0) {
				System.out.println(ele.getText());
			}
		}
		
		//Get the last link
		System.out.println(driver.findElement(By.xpath("//span[@jscontroller]//div[@jsname]/div")).getText());
		System.out.println("");
		
		
		
		
	

	}

}
