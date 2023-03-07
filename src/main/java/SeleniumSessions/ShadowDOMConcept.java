package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(5000);
		
		//The below line will not work since it is a input element locted within shadow dom
		//EXCEPTION is fired as:
		//Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//input[@id='pizza']"}
		//driver.findElement(By.xpath("//input[@id='pizza']")).sendKeys("veg pizza");
		
		//Traverse Path
		//browser ---> page ---> shadowDOM ---> shadowDOM ---> input
		
		//document.querySelector("#userName").shadowRoot.querySelector("#app2").shadowRoot.querySelector("#pizza")
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement pizzaInputShadowDomEle =  (WebElement)js.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
		pizzaInputShadowDomEle.sendKeys("veg pizza");

	}

}
