package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextForTextField {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(4000);
		
		//
		WebElement firstNameWebEle = driver.findElement(By.id("input-firstname"));
		firstNameWebEle.sendKeys("TestingNigel");
		
		String inputValue = firstNameWebEle.getAttribute("value");
		System.out.println("InputValue: "+inputValue);
		
		//WebElement lastNameWebEle = driver.findElement(By.id("input-lastname"));
		//Fires a EXCEPTION
		//Exception in thread "main" java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
		//lastNameWebEle.sendKeys(null);

	}

}
