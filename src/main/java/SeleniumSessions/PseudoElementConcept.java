package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(4000);

		//Sample XPath
		//For example: //window.getComputedStyle(document.querySelector("label[for='input-email']"), '::before').getPropertyValue("content")

		//Cast the driver to JavaScriptExecutor
		JavascriptExecutor jsExec = (JavascriptExecutor)driver;
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-email']\"), '::before').getPropertyValue(\"content\")";
		String symbol = jsExec.executeScript(script).toString();
		System.out.println("Symbol: "+symbol);
		
		
	}

}
