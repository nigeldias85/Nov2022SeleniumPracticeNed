package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(2000);
		
		
		//WebElement for the draggable component
		WebElement sourceWebEle = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destinationWebEle = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act = new Actions(driver);
		//click and hold , move and then release
		//act.clickAndHold(sourceWebEle).moveToElement(destinationWebEle).release().build().perform();
		//act.clickAndHold(sourceWebEle).moveToElement(destinationWebEle).release().perform();
		
		//Action Classes work with
		//Build and Perform
		//Perform
		
		//Action Classes will not work with
		//only build
		//no build and perform
		
		//Drag and Drop directly
		act.dragAndDrop(sourceWebEle, destinationWebEle).build().perform();
	}

}
