package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	
	
	private WebDriver driver;
	
	/**
	 * This method is used to initialize the driver based on browser name
	 * @param browserName
	 * @return This returns the specific driver for browser
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("Browser Name is: "+browserName);
		
		//Create switch case
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please pass the right browser... "+browserName);
			break;
		}
		
		//Clear cookies and maximize window
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	
	public void launchUrl(String url) {
		if(url == null) {
			System.out.println("URL cannot be null");
		}
		
		if(url!= null && url.indexOf("https") == 0) {
			driver.get(url);
		}
	}
	
	
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("PageTitle: "+pageTitle);
		return pageTitle;
	}
	
	
	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Url: "+pageUrl);
		return pageUrl;
	}
	
	public void closeBrowser() {
		if(driver != null) {
			driver.close();
		}
	}
	
	
	public void quitBrowser() {
		if(driver != null) {
			driver.quit();
		}
	}

}
