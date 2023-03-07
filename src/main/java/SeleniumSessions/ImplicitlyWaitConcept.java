package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		
		//This is a Global Wait for 5 Seconds
		//It will be applied to all elements by default
		//FE -> Implicitly wait will be applied to all automatically.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Available from Sel4.x
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("welcome@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Implicitly wait applicable for: Svg, iFrame, All WE's
		//Implicitly wait DOES NOT support: title, url, alert-js
	}

}
