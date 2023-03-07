package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithFluentFeatures {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//WebDriverWait ---> Fluent Wait ---> Wait

		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		By freeTrialLocator = By.cssSelector("a[title='Free Trial111']");
		
		//Here the default polling of 500 millis is applied
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage("-----ELEMENT NOT FOUND---------");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(freeTrialLocator)).click();
		
		//Here the default polling of 500 millis is over-ridden  to 2 seconds
//		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.presenceOfElementLocated(freeTrialLocator)).click();
		
		

	}

}
