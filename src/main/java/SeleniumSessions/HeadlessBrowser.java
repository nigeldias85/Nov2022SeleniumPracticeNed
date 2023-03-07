package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		
		//Browser is not visible, but it is launched
		//Headless - testing is happening behind the scenes
		//Faster than normal code
		
		//Usefull for sanity testcase
		//Might not work for Complex html DOM
		
		ChromeOptions co = new ChromeOptions();
		//co.setHeadless(false);
		//co.addArguments("--headless");
		co.addArguments("--incognito");
		
		driver = new ChromeDriver(co);
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println("Title: "+driver.getTitle());
		System.out.println("Url: "+driver.getCurrentUrl());

	}

}
