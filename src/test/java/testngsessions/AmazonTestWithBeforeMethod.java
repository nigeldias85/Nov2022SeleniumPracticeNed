package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTestWithBeforeMethod {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	
	//Test cases should be independent
	//AAA Rule - Arrange, Act and Assert
	//1 TC  -- 1 Assertion
	@Test(priority = 1)
	public void titleTest() {
		System.out.println("Test: titleTest");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	
	
	@Test(priority = 2)
	public void searchExistsTest() {
		System.out.println("Test: searchExistsTest");
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		Assert.assertTrue(ele.isDisplayed());
		
	}
	
	
	@Test(priority = 3)
	public void isHelpsExistTest() {
		System.out.println("Test: isHelpsExistTest");
		WebElement ele = driver.findElement(By.linkText("Help"));
		Assert.assertTrue(ele.isDisplayed());
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
