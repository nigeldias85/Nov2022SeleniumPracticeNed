package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopupHandle {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//Upload a file
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\NIGEL\\Downloads\\EpfoErrorOnTransfer.jpg");
		
		// tag<type='File'> should be present to use sendKeys on a button choose file
		

	}

}
