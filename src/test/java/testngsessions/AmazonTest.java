package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest{
	
//	WebDriver driver;
	
//	@BeforeTest
//	public void setUp() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.amazon.com/");
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//	}
	
	
	//	NOT VALID/RECOMMENDED
//	@Test
//	public void amazonPageTest() {
//		System.out.println("Test: titleTest");
//		String title = driver.getTitle();
//		System.out.println("Title: "+title);
//		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
//		
//		System.out.println("Test: searchExistsTest");
//		WebElement ele1 = driver.findElement(By.id("twotabsearchtextbox"));
//		Assert.assertTrue(ele1.isDisplayed());
//		
//		System.out.println("Test: isHelpsExistTest");
//		WebElement ele2 = driver.findElement(By.linkText("Help"));
//		Assert.assertTrue(ele2.isDisplayed());
//	}
	
	
	//Test cases should be independent
	@Test
	public void titleTest() {
		System.out.println("Test: titleTest");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	
	
	@Test
	public void searchExistsTest() {
		System.out.println("Test: searchExistsTest");
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		Assert.assertTrue(ele.isDisplayed());
		
	}
	
	
	@Test
	public void isHelpsExistTest() {
		System.out.println("Test: isHelpsExistTest");
		WebElement ele = driver.findElement(By.linkText("Help"));
		Assert.assertTrue(ele.isDisplayed());
		
	}
	
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
