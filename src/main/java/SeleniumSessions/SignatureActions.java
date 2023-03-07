package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SignatureActions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");
		Thread.sleep(4000);
		
		WebElement signPad = driver.findElement(By.id("signature-pad"));
		
		Actions act = new Actions(driver);
		act.click(signPad).moveToElement(signPad, 60, 40).clickAndHold(signPad).moveToElement(signPad, 35, 45)
		.moveByOffset(-100, 50)
		.moveByOffset(35, 50)
		.moveByOffset(-35, 60)
		.release(signPad).build().perform();

	}

}
