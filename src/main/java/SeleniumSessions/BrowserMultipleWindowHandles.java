package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowHandles {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentWindowId = driver.getWindowHandle();
		Thread.sleep(3000);

		//Get the WebElement links for all the footer elements
		WebElement twEle =  driver.findElement(By.xpath("//a[contains(@href, 'twitter.com')]"));
		WebElement fbEle =  driver.findElement(By.xpath("//a[contains(@href, 'facebook.com')]"));
		WebElement ytEle =  driver.findElement(By.xpath("//a[contains(@href, 'youtube.com')]"));
		WebElement linkEle =  driver.findElement(By.xpath("//a[contains(@href, 'linkedin.com')]"));
		
		//Open all the links
		twEle.click();
		fbEle.click();
		ytEle.click();
		linkEle.click();
		
		
		//Get all the window handles
	    Set<String> windowHandles = driver.getWindowHandles();
	    
	    
	    //Iterate through all the window handles
	    Iterator<String> iter = windowHandles.iterator();
	    while(iter.hasNext()) {
	    	String windowId = iter.next();
	    	driver.switchTo().window(windowId);
	    	Thread.sleep(3000);
	    	if(!windowId.equals(parentWindowId)) {
	    		System.out.println("Title: "+driver.getTitle());
		    	System.out.println("Url: "+driver.getCurrentUrl());
	    		driver.close();
	    	}
	    	
	    	System.out.println("");
	    }
	    
	    
	    //Switch back to main parent
	    driver.switchTo().window(parentWindowId);
	    System.out.println("Title: "+driver.getTitle());
    	System.out.println("Url: "+driver.getCurrentUrl());

	}

}
