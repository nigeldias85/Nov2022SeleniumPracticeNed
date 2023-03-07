package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Fits the window to the screen length of the monitor/laptop screen
		//driver.manage().window().fullscreen();
		
		
		//Delete all the cookies prior to start of testing
		driver.manage().deleteAllCookies();
		
		
		//Get the current url of the page.
		String currentUrl = driver.getCurrentUrl();
		System.out.println("CurrentUrl: "+currentUrl);
		if(currentUrl.contains("amazon"))
			System.out.println("Passed");
		
		//Get the page source
		String pageSource = driver.getPageSource();
		System.out.println("");
		System.out.println("PageSource: "+pageSource);
		System.out.println("");
		if(pageSource.contains("NAVYAAN FOOTER START"))
			System.out.println("PASSED");
		
		
		//Quit all the browser instances
		driver.quit();
		
	}
}
