package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		// Click on the twitter link at the footer
		driver.findElement(By.xpath("//a[contains(@href, 'twitter.com')]")).click();

		// Get the window handles of all the windows open
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();

		// Loop through the window IDs and print each window ID
		String parentWindowId = windowHandles.iterator().next();
		String windowId = "";
		while (iter.hasNext()) {
			windowId = iter.next();
			System.out.println("WindowId: " + windowId);
		}

		// Switch to the child window
		driver.switchTo().window(windowId);

		// Capture the child window titles
		System.out.println("Title: " + driver.getTitle());
		System.out.println("Url: " + driver.getCurrentUrl());

		// Close the child window
		driver.close(); // Close the child window.

		// Switch back to parent window
		driver.switchTo().window(parentWindowId);

		// Capture the parent window titles
		System.out.println("Title: " + driver.getTitle());
		System.out.println("Url: " + driver.getCurrentUrl());
		
		//Close the parent window
		driver.quit();

	}

}
