package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageDataProviderTest {
	
	public WebDriver driver;
	
	
	public void doRegister(String firstName, String lastName, String email, String phone, String password) throws InterruptedException {
		
		//Clear each field and enter the value
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		Thread.sleep(3000);
	
	}
	
	@DataProvider
	public Object [][] getRegTestData() {
		return new Object [][] {
			{"Heena", "Vagela", "heena@gmail.com", "1234567890", "heena@123"},
			{"Vinuta", "Ravindra", "vinuta@gmail.com", "1234567891", "vinuta@123"},
			{"Supriya", "Kumar", "supriya@gmail.com", "1234567892", "supriya@123"}
		};
	}
	
	@Test(dataProvider = "getRegTestData")
	public void registerTest(String firstName, String lastName, String email, String phone, String password) throws InterruptedException {
		System.out.println("Registering Data...");
		System.out.println(firstName+" : "+lastName+" : "+email+" : "+phone+" : "+password );
		doRegister(firstName, lastName, email, phone, password);
		System.out.println("");
	}
	
	
	
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	
	//@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
