package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentWindowId = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//Introduced in Selenium 4.0
		driver.switchTo().newWindow(WindowType.WINDOW); //Opens a window  
		//driver.switchTo().newWindow(WindowType.TAB); //Opens a new tab alongside the current one 
		
		//For the new WINDOW or TAB , navigate to the URL.
		driver.get("https://www.amazon.com");
		System.out.println("Title: "+driver.getTitle());
		
		//Close the new window
		driver.close();
		
		//Switch back to parent
		System.out.println("");
		driver.switchTo().window(parentWindowId);
		System.out.println("Title: "+driver.getTitle());
		
		//Close the parent window
		driver.quit();
		
		//Handling Random PopUps
		//Cannot be handled through Selenium
		//Only required for PROD
		//On QA/Stage/Test env's, this has to be blocked.
	}

}
