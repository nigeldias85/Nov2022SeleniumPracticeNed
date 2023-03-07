package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//From 4.6.0 explicitly setting driver path not required
		//Prior to 4.6.0 , we had to configure the .exe(binary) file for the driver
		
		//For sel version 4.5.3 we get an error
		//As a workaround we set the property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Downloads\\chromedriver.exe");
		
		//From 4.6.0 onwards , a selenium manager takes care of this
		//The binary is chosen in line the browser version

	}

}
