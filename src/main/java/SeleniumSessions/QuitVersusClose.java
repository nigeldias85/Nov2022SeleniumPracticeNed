package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVersusClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Session ID : SID
		/*WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit(); //After this steps SID = null
		driver = new ChromeDriver(); //Here a NEW SID is created
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());*/ // Fires a NoSuchSessionException
		// Exception in thread "main" org.openqa.selenium.NoSuchSessionException:
		// Session ID is null. Using WebDriver after calling quit()?

		// Session ID : SID
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close(); //After this steps, SID is SAME, BUT invalid
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle()); //Fires as exception
		//Exception in thread "main" org.openqa.selenium.NoSuchSessionException: invalid session id

	}

}
