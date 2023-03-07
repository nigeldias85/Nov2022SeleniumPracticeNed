package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(3000);
		//Fires a EXCEPTION
		//Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"tag name","selector":"h2"}
		//System.out.println("Text: "+driver.findElement(By.tagName("h2")).getText());
		
		//Get all the frames on the page
		System.out.println("TotalFrames: "+driver.findElements(By.xpath("//frame")).size());
		
		
		//Navigate to frame based on index
		driver.switchTo().frame(2);
		System.out.println("FrameText: "+driver.findElement(By.tagName("h2")).getText());
		//Switch back to the main window
		driver.switchTo().defaultContent();
		
		//Navigate to frame based on name or id
		driver.switchTo().frame("main");
		System.out.println("FrameText: "+driver.findElement(By.tagName("h2")).getText());
		//Switch back to the main window
		driver.switchTo().defaultContent();
		
		//Navigate to frame based on xpath of the frame
		WebElement frameElement = driver.findElement(By.xpath("//frame[@src='top.html']"));
		driver.switchTo().frame(frameElement);
		System.out.println("FrameText: "+driver.findElement(By.tagName("h2")).getText());
		
		//Switch back to the main window
		driver.switchTo().defaultContent();
		
		//Frame Versus iFrame
		//Selenium treats them similarly
		//Frame
		//iFrame --> Provides more security, 
		
		

	}

}
