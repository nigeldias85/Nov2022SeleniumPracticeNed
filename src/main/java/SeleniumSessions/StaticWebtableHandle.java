package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StaticWebtableHandle {

	static RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(4000);
		
		int headerCount = getTableHeaderCount();
		System.out.println("HeaderCount: "+headerCount);
		
		int rowCount = getTableRowCount();
		System.out.println("RowCount: "+rowCount);
		
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[1]";
		
		//Iterate
		for(int i=2; i<=rowCount+1; i++) {
			String xpath = beforeXpath + i + afterXpath;
			System.out.println("XPATH: "+xpath);
			
			String value = driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Value: "+value);
		}

	}
	
	public static int getTableHeaderCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//th")).size();
	}
	
	public static int getTableRowCount() {
		return (driver.findElements(By.xpath("//table[@id='customers']//tr")).size()) - 1;
	}

}
