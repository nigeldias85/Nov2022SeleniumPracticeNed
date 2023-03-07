package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//System.out.println(driver.getTitle()); //Loading the title might take some time
		
		//Click on forgot password
		driver.findElement(By.linkText("Forgotten Password")).click();
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.titleContains("Password?"));
//		
//		System.out.println("Title: "+driver.getTitle()); //Get the title after the title is available
		
		System.out.println(waitForTitleContainsAndFetch(5, "Password?"));
		
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.linkText("Mobiles")).click();
		boolean blnRes = waitForUrlContains(5, "mobile-phones");
		if(blnRes)
			System.out.println("Url is correct");

	}
	
	
	public static String waitForTitleContainsAndFetch(int timeout, String titlePartialValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleContains(titlePartialValue));
		return driver.getTitle();
	}
	
	public static String waitForTitleIsAndFetch(int timeout, String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}
	
	
	public static String waitForUrlContainsAndFetch(int timeout, String urlPartialValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlContains(urlPartialValue));
		return driver.getCurrentUrl();
	}
	
	public static String waitForUrlIsAndFetch(int timeout, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlToBe(urlValue));
		return driver.getCurrentUrl();
	}
	
	public static boolean waitForUrlContains(int timeout, String urlPartialValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(urlPartialValue));
	}

}
