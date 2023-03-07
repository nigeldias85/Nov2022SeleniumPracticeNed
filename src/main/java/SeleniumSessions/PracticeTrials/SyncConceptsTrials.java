package SeleniumSessions.PracticeTrials;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncConceptsTrials {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.facebook.com");
		By usernameLocator = By.name("email");
		doSendKeys(usernameLocator, Duration.ofSeconds(5), "naveen@gmail.com");
		By passwordLocator = By.name("pass");
		doSendKeys(passwordLocator, Duration.ofSeconds(5), "welcome@123");
		
		By crtNewAccbBtnLocator = By.xpath("//a[@role='button' and contains(text(), 'Create new account')]");
		clickElement(crtNewAccbBtnLocator, Duration.ofSeconds(5));
		Thread.sleep(1000);
		
		WebDriver newDriver = driver.switchTo().defaultContent();
		WebElement submitButton = newDriver.findElement(By.xpath("//button[@name='websubmit']"));
		new WebDriverWait(newDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='websubmit']")));
		
		//System.out.println("NewTxt: "+newDriver.findElement(By.id("birthday_wrapper")).getText());
		//System.out.println("FirstName: "+driver.findElement(By.xpath("//form[@id='reg']")).isDisplayed());
		
		By firstNameLocator = By.name("firstname");
		//By firstNameLocator = By.xpath("//form[@id='reg']//input[@name='firstname']");
		
		//newDriver.findElement(firstNameLocator).sendKeys("Paul")
		doSendKeys(newDriver, firstNameLocator, Duration.ofSeconds(5), "Paul");
		
		By lastNameLocator = By.name("lastname");
//		newDriver.findElement(lastNameLocator).sendKeys("Paul");
		doSendKeys(newDriver, lastNameLocator, Duration.ofSeconds(2), "Allen");
		
		

	}
	
	public static void doSendKeys(By locator, Duration duration, String input) {
		WebElement inputElement = driver.findElement(locator);
		new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(inputElement));
		inputElement.sendKeys(input);
	}
	
	public static void doSendKeys(WebDriver driver, By locator, Duration duration, String input) {
		WebElement inputElement = driver.findElement(locator);
		new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(inputElement));
		inputElement.sendKeys(input);
	}
	
	public static void clickElement(By locator, Duration duration) {
		WebElement eletoBeClicked = driver.findElement(locator);
		new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(eletoBeClicked));
		eletoBeClicked.click();
	}

}
