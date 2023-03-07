package SeleniumSessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Will not work for cross-browser
		ChromeDriver driver1 = new ChromeDriver();  //Only for Chrome
		FirefoxDriver driver2 = new FirefoxDriver(); //Only for FF
		
		//2. WD = new CD()  , Valid Top Casting and recommended -- Used for Local execution
		WebDriver driver3 = new ChromeDriver();
		
		//3. SC = new CD(); , Valid Top Casting and not recommended
		SearchContext driver4 = new ChromeDriver();
		
		//4. RWD = new CD(); , Valid Top Casting and recommended
		RemoteWebDriver driver5 = new ChromeDriver();
		
		//5. WD = new RWD(); , Valid Top Casting and recommended -- Used for remote execution
		WebDriver driver6 = new RemoteWebDriver(null);
		
		//6. SC = new RWD(); , Valid but not recommended
		SearchContext driver7 = new RemoteWebDriver(null);
		

	}

}
