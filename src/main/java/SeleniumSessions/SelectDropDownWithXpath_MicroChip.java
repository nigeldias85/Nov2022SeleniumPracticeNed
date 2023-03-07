package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithXpath_MicroChip {

	static RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.microchip.com/prochiplicensing");
		Thread.sleep(4000);
		
		WebElement designSelectElement = driver.findElement(By.xpath("//label[contains(text(), 'design planned')]/preceding-sibling::select"));
		Select select = new Select(designSelectElement);
		
		select.selectByVisibleText("2023");
		
		

	}

}
