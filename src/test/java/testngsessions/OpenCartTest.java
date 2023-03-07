package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {
	

//	WebDriver driver;
	
//	@BeforeTest
//	public void setUp() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://naveenautomationlabs.com/opencart/");
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//	}
	
	
	
	
	//Test cases should be independent
	@Test
	public void titleTest() {
		System.out.println("Test: titleTest");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		Assert.assertEquals(title, "Your Store");
	}
	
	
	@Test
	public void searchExistsTest() {
		System.out.println("Test: searchExistsTest");
		WebElement ele = driver.findElement(By.name("search"));
		Assert.assertTrue(ele.isDisplayed());
		
	}
	

	
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
