package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class RightClickHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(2000);
		
		//WebElement for context menu
		WebElement contextMenuWebEle = driver.findElement(By.xpath("//span[contains(@class, 'context-menu-one')]"));

		Actions act = new Actions(driver);
		act.contextClick(contextMenuWebEle).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> contextMenuElements = 
				driver.findElements(By.xpath("//ul[contains(@class, 'context-menu')]//span"));
		
		for(WebElement ele: contextMenuElements) {
			String text = ele.getText();
			System.out.println("Value: "+text);
			if(text.equals("Quit")) {
				ele.click();
				Alert alert = driver.switchTo().alert();
				System.out.println("AlertText: "+alert.getText());
				alert.accept();
				break;
			}
		}
		
	}

}
