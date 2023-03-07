package testngsessions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest {
	
	
	public WebDriver driver;
	
	public boolean doLogin(String username, String password) {
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String errorText = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
		System.out.println("ErrorText: "+errorText);
		if(errorText.contains("No match for E-Mail Address and/or Password")) {
			return true;
		}
		return false;
	}
	
	@DataProvider
	public Object [][] getLoginNegativeData() {
		
		return new Object [][] {
			{"nigel@gmail.com", "Welcome@123"},
			{"naveen@gmail.com", "Welcome@123"},
			{"tom@gmail.com", ""},
			{"nigel", "Welcome@123"}
		};
	}
	
	
	@Test(dataProvider = "getLoginNegativeData")
	public void doLoginTest(String username, String password) throws InterruptedException {
		//Assert.assertTrue(doLogin("nigel@gmail.com", "Welcome@123"));
		Random rnd = new Random();
		if(username != null || username != "") {
			if(username.contains("@")) {
			username = (username.split("@"))[0] + rnd.nextInt() + "@" + (username.split("@"))[1];
			}
			else {
				username = username + rnd.nextInt();
			}
		}
		
		System.out.println("Testing with: "+username+" and "+password);
		Assert.assertTrue(doLogin(username, password));
		System.out.println("");
		
	}
	
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
