package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebtableHandling {
	static RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(4000);
		
		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(4000);
		
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(4000);
		
		//a[text()='Ali khan']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//Select checkbox for a user
		selectUser("Ali khan");
		String cName = getCompanyName("Ali khan");
		System.out.println("cName: "+cName);
		
		
		selectUser("Romi singh");
		cName = getCompanyName("Romi singh");
		System.out.println("cName: "+cName);
		

	}
	
	
	public static void selectUser(String username) {
		String xpath = "//a[text()='"+username+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		System.out.println("xPath: "+xpath);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static String getCompanyName(String username) {
		String xpath = "//a[text()='"+username+"']/parent::td/following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(xpath)).getText();
	}

}
