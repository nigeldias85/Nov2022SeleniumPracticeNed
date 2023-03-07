package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopupHandle {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		String username = "admin";
		String password = "admin"; //Password should not contain @ since it is part of the URL
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		
		String confirmText = driver.findElement(By.xpath("//h3/following-sibling::p")).getText();
		System.out.println("AuthPopUpConfirmation: "+confirmText);
		
		

	}

}
