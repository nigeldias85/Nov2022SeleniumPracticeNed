package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopup {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//JS Alert -> Alert, Prompt , Confirmation
		//Auth PopUp
		//Browser WindowPopUp/Adv PopUp
		//File Upload PopUp
		
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Open the Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		
		//Switch the driver instance to the alert
		Alert jsAlert = driver.switchTo().alert();
		String alertText = jsAlert.getText();
		System.out.println("AlertText: "+alertText);
		//Handle the Alert
		jsAlert.accept();
		
		//Dimiss the Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		jsAlert = driver.switchTo().alert();
		jsAlert.dismiss();
		
		//Open the Confirm
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		
		//Switch the driver instance to the prompt
		Alert confirmAlert = driver.switchTo().alert();
		
		//EXCEPTION fired, if the alert is not open and we try to switch
		//Exception in thread "main" org.openqa.selenium.NoAlertPresentException: no such alert

		String confirmAlertText = confirmAlert.getText();
		System.out.println("ConfirmAlertText: "+confirmAlertText);
		
		//Handle the alert
		confirmAlert.accept();
		
		//Cancel the alert
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		confirmAlert.dismiss();
		
		
		//Open the prompt
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		//Switch the driver instance to the confirmation
		Alert promptAlert = driver.switchTo().alert();
		
		String promptAlertText = promptAlert.getText();
		System.out.println("PromptAlertText: "+promptAlertText);
		
		//Enter a value in the prompt
		promptAlert.sendKeys("Prompt Testing");
		promptAlert.accept();
		
		//Check the value entered in the message displayed below
		System.out.println("PromptText: "+driver.findElement(By.xpath("//h4/following-sibling::p")).getText());
		
		
		
		
		
		
		
		
		
		

	}

}
