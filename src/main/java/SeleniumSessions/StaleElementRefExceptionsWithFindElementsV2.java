package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionsWithFindElementsV2 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(2000);
		
		List<WebElement> footerEleList = driver.findElements(By.xpath("//footer//a"));
		
		for(int i=0;i<footerEleList.size();i++) {
			footerEleList.get(i).click();
			driver.navigate().back();
			Thread.sleep(2000);
			footerEleList = driver.findElements(By.xpath("//footer//a"));
		}
		

	}

}
