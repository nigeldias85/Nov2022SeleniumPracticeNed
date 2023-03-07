package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//1.Open Browser: Chrome , FF
		//ChromeDriver driver =  new ChromeDriver();
		//WebDriver driver =  new ChromeDriver();
		//WebDriver driver =  new FirefoxDriver();
		//WebDriver driver =  new EdgeDriver();
		
		
		String browser = "chrome";
		WebDriver driver=null;;
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please pass the right browser: "+browser);
		}
		
		
		//2.Launch the Url
		driver.get("https://www.google.com");
		
		//3.Get the title of the page
		String actualPageTitle = driver.getTitle();
		System.out.println("Title: "+actualPageTitle);
		
		//4.Validation
		if(actualPageTitle.equals("Google"))
			System.out.println("Passed");
		else 
			System.out.println("Failed");
		
		//Automation Steps + Validation/assertions = AutomationTesting
		
		//5.Close the Browser
		driver.quit();

	}

}
