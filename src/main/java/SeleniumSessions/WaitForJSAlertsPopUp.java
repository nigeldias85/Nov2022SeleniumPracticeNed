package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForJSAlertsPopUp {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// Open the Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("AlertText: "+alert.getText());
		alert.accept();
		
//		Thread.sleep(3000);
//
//		// Switch the driver instance to the alert
//		Alert jsAlert = driver.switchTo().alert();
//		String alertText = jsAlert.getText();
//		System.out.println("AlertText: " + alertText);
//		// Handle the Alert
//		jsAlert.accept();

	}
	
	public static Alert waitForJSAlertPresence(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public static String getAlertText(int timeout) {
		return waitForJSAlertPresence(timeout).getText();
	}
	
	
	public static void acceptAlert(int timeout) {
		waitForJSAlertPresence(timeout).accept();
	}
	
	
	public static void dismissAlert(int timeout) {
		waitForJSAlertPresence(timeout).dismiss();
	}
	
	
	public static void alertSendKeys(int timeout, String value) {
		waitForJSAlertPresence(timeout).sendKeys(value);
	}

}
