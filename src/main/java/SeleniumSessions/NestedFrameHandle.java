package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class NestedFrameHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		Thread.sleep(4000);
		
		//nested iframes
			//f1
				//f2
					//f3
		
		//Switch to frame1
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("Frame1Input");
		
		
		//Switch to frame2
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("Frame2Input");
		
		//Change input in frame1
		driver.switchTo().parentFrame(); //  Switch back to Frame1
		driver.findElement(By.id("inp_val")).clear();
		driver.findElement(By.id("inp_val")).sendKeys("Frame1InputUpdated");
		
		//Switch to frame3
		driver.switchTo().frame("pact2");
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("Frame3Input");
		
		//Switch back to main frame or Frame1
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("pact1");
//		driver.findElement(By.id("inp_val")).clear();
//		driver.findElement(By.id("inp_val")).sendKeys("Frame1InputModified");
		
		//Switch back to main frame or Frame1
		driver.switchTo().parentFrame(); //Switch back to f2
		driver.switchTo().parentFrame(); //Switch back to f1
		driver.findElement(By.id("inp_val")).clear();
		driver.findElement(By.id("inp_val")).sendKeys("Frame1InputModified");
		
		//Navigate back to main page
		driver.switchTo().defaultContent();
		
	}

}
