package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		Thread.sleep(2000);
		
		//For example xpath is 
		// //a[contains(text(), 'Content')]
		
		//WebElement for the content menu
		WebElement contentMenuWebElement = driver.findElement(By.cssSelector("a.menulink"));
		
		//Move to menu and open the options
		Actions act = new Actions(driver);
		act.moveToElement(contentMenuWebElement).build().perform();
		Thread.sleep(2000);
		
		//Click on courses
		WebElement coursesWebEle = driver.findElement(By.linkText("COURSES"));
		coursesWebEle.click();
		
		//SPICE Jet UseCase
		driver.get("https://www.spicejet.com/");
		String primaryWindowId = driver.getWindowHandle();
		Thread.sleep(2000);
		WebElement addonMenu = driver.findElement(By.xpath("//div[contains(text(), 'Add-ons')]"));
		act.moveToElement(addonMenu).build().perform();
		Thread.sleep(2000);
		
		//Click on Zero Cancellation
		driver.findElement(By.xpath("//div[contains(text(), 'Cancellation')]")).click();
		Thread.sleep(3000);
		
		//Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Size: "+windowHandles.size());
		
		System.out.println("");
		Iterator<String> iter = windowHandles.iterator();
		String windowId="";
		while(iter.hasNext()) {
			windowId = iter.next();
			System.out.println("WindowId: "+windowId);
		}
		
		//Switch to new window
		driver.switchTo().window(windowId);
		
		//Print the content
		System.out.println(driver.findElement(By.xpath("//p[@class='text-center']")).getText());
		
		//Close the new window
		driver.close();
		
		//Move back to parent
		driver.switchTo().window(primaryWindowId);
		
		
		//Close the parent
		driver.quit();

	}

}
