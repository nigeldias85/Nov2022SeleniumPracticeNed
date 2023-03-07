package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		Thread.sleep(4000);
		
		//https://jqueryui.com/resources/demos/slider/default.html
		WebElement sliderWebEle = driver.findElement(By.id("slider"));
		//Move the slider to the middle
		sliderWebEle.click();
		Thread.sleep(3000);
		
		int sw = sliderWebEle.getSize().getWidth();
		System.out.println("SW: "+sw);
		int mp = sw/2;
		
		Actions act = new Actions(driver);
//		act.moveToElement(sliderWebEle, (mp-50), 0).click().build().perform(); //Move Right
//		Thread.sleep(3000);
//		act.moveToElement(sliderWebEle, -(mp-70), 0).click().build().perform(); //Move Left
		
		//Moving the slide using clickAndHold
		act.clickAndHold(sliderWebEle).moveByOffset((mp-50), 0).build().perform();
		

	}

}
