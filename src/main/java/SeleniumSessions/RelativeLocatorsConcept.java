package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(2000);
		
		//Relative Locators
		//Traversing Left, Right, Above and Below Locators
		
		//		Above
		//Left		.		Right
		//		Below
		
		//Introduced in Sel 4.x
		
		//Create a WebElement for the base element
		WebElement baseElement = driver.findElement(By.xpath("//a[contains(text(), 'Beloeil, Canada')]"));
		
		//Get Right and Left of Base Element
		WebElement rightOfBaseEle = driver.findElement(with(By.tagName("p")).toRightOf(baseElement));
		System.out.println("RightElementText: "+rightOfBaseEle.getText());
		System.out.println("");
		
		WebElement leftOfBaseEle = driver.findElement(with(By.tagName("p")).toLeftOf(baseElement));
		System.out.println("LeftElementText: "+leftOfBaseEle.getText());
		System.out.println("");
		
		//Get Above and Below of Base Element
		WebElement aboveTheBaseEle = driver.findElement(with(By.tagName("p")).above(baseElement));
		System.out.println("AboveElementText: "+aboveTheBaseEle.getText());
		System.out.println("");
		
		WebElement belowTheBaseEle = driver.findElement(with(By.tagName("p")).below(baseElement));
		System.out.println("BelowElementText: "+belowTheBaseEle.getText());
		System.out.println("");
		
		//Get the nearest element to the base element
		WebElement nearBaseEle =  driver.findElement(with(By.tagName("a")).near(baseElement));
		System.out.println("NearElementText: "+nearBaseEle.getText());
		System.out.println("");
		
		
	}

}
