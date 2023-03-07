package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcepts {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//driver.navigate().to("https://www.google.com");
		System.out.println("Title1: "+driver.getTitle());
		
		//driver.navigate().to("https://www.amazon.com");
		driver.navigate().to(new URL("https://www.amazon.com"));
		//driver.get("https://www.amazon.com");
		System.out.println("Title2: "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Title3: "+driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("Title4: "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Title5: "+driver.getTitle());
		
		driver.navigate().refresh(); //ReLoads the page
		
		
		

	}

}
