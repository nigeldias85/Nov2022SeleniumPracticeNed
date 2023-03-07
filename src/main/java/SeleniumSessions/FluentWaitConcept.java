package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//WebDriverWait ---> Fluent Wait ---> Wait

		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		//By freeTrialLocator = By.cssSelector("a[title='Free Trial123']");
		By freeTrialLocator = By.xpath("//a[@title='Free Trial 123']");
		
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class)
//				.pollingEvery(Duration.ofSeconds(2))
//				.withMessage("-------ELEMENT is NOT found--------");
//		
//		WebElement freeTrial = wait.until(ExpectedConditions.visibilityOfElementLocated(freeTrialLocator));
//		freeTrial.click();
		
		waitForElementPresenceWithFluentWait(freeTrialLocator, 10, 2).click();
		
	}
	
	
	
	public static WebElement waitForElementPresenceWithFluentWait(By locator, int timeout, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.withMessage("....ELEMENT is NOT found.......");
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public static void waitForAlertWithFluentWait(int timeout, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.ignoring(NoAlertPresentException.class)
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.withMessage("....ALERT is NOT found.......");
		
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
