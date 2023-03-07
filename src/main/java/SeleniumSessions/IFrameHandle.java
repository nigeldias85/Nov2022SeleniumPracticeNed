package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);

		//click on the registration form img
		driver.findElement(By.xpath("//img[@title='vehicle-registration-forms-and-templates']")).click();
		Thread.sleep(3000);
		
		By iframeLocator = By.xpath("//iframe[contains(@id, 'frame-one')]");
		driver.switchTo().frame(driver.findElement(iframeLocator));
		
		//Gives: Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#RESULT_TextField\-7"}
		//Since we try to enter vales before switching to iFrame
		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("India-9090");
		
		//Switch back out from the frame
		driver.switchTo().defaultContent();
	}

}
