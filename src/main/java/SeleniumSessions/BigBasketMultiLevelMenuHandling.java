package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMultiLevelMenuHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(4000);
		
		
//		WebElement l1Element = driver.findElement(By.cssSelector("a.meganav-shop"));
//		Actions act = new Actions(driver);
//		act.moveToElement(l1Element).build().perform();
//		Thread.sleep(2000);
//		
//		WebElement l2Element = driver.findElement(By.linkText("Beverages"));
//		act.moveToElement(l2Element).build().perform();
//		Thread.sleep(2000);
//		
//		WebElement l3Element = driver.findElement(By.linkText("Fruit Juices & Drinks"));
//		act.moveToElement(l3Element).build().perform();
//		Thread.sleep(2000);
//		
//		WebElement l4Element = driver.findElement(By.linkText("Syrups & Concentrates"));
//		act.moveToElement(l4Element).click().build().perform();
//		Thread.sleep(2000);
		
		By l1CategoryLocator = By.cssSelector("a.meganav-shop");
		//selectProductLevel4Handling(l1CategoryLocator, "Beverages", "Fruit Juices & Drinks", "Syrups & Concentrates");
		selectProductLevel4Handling(l1CategoryLocator, "Kitchen, Garden & Pets", "Cookware & Non Stick", "Pressure Cookers");

	}
	
	
	public static void selectProductLevel4Handling(By l1CategoryLoctor, String l2, String l3, String l4) throws InterruptedException {
		//WebElement l1Element = driver.findElement(By.cssSelector("a.meganav-shop"));
		WebElement l1Element = driver.findElement(l1CategoryLoctor);
		Actions act = new Actions(driver);
		act.moveToElement(l1Element).build().perform();
		Thread.sleep(2000);
		
		WebElement l2Element = driver.findElement(By.linkText(l2));
		act.moveToElement(l2Element).build().perform();
		Thread.sleep(2000);
		
		WebElement l3Element = driver.findElement(By.linkText(l3));
		act.moveToElement(l3Element).build().perform();
		Thread.sleep(2000);
		
		WebElement l4Element = driver.findElement(By.linkText(l4));
		act.moveToElement(l4Element).click().build().perform();
		Thread.sleep(2000);
	}

}
