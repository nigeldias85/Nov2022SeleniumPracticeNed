package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		Thread.sleep(4000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Get the page title using js
//		String pageTitle = js.executeScript("return document.title;").toString();
//		System.out.println("PageTitle: "+pageTitle);
		
		//Generate Alert
//		js.executeScript("alert('This is a custom alert');");
		
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		System.out.println(jsUtil.getTitleByJS());
		
		//jsUtil.generateAlert("This is a custom alert");
		//jsUtil.generateConfirmationPopUp("Are you sure you want to proceed?");
		
		//Refresh the page
		jsUtil.refreshBrowserByJS();
		
		//Get page inner text
		String pageInnerText = jsUtil.getPageInnerText();
		System.out.println("PageInnerText: "+pageInnerText);
		
		WebElement headerMenuOptions = driver.findElement(By.xpath("//div[@id='nav-xshop']"));
		jsUtil.drawBorder(headerMenuOptions);
		
		//Get Webelement for amazon search
//		WebElement searchElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//		jsUtil.flash(searchElement);
//		searchElement.sendKeys("iPhone 14");
		
		//Scroll to bottom of page
		jsUtil.scrollPageDown();
		Thread.sleep(3000);
		
		//Scroll to top of the page
		jsUtil.scrollPageUp();
		Thread.sleep(3000);
		
		//Scroll down to a certain height
		jsUtil.scrollPageDown("300");
		Thread.sleep(3000);
		
		//Scroll to the middle of the page
		jsUtil.scrollHalfPageDown();
		Thread.sleep(3000);
		
		//Scroll back to the top of the page
		jsUtil.scrollPageUp();
		Thread.sleep(3000);
		
		//Create a WebElement for a specific location
		WebElement kindleReaders = driver.findElement(By.xpath("//div[@class='a-cardui-header']/h2[contains(text(), 'Kindle')]"));
		jsUtil.scrollIntoView(kindleReaders);
		Thread.sleep(3000);
		
		//Three types of click
		//click -> From the UI , Click on the middle of the element
		//Actions click -> Move to the element and click on middle of the element
		//JS Click -> Click from DOM
		
		//Click the specific element using js
		WebElement kindleElement = driver.findElement(By.xpath("//a[contains(@href, 'Kindle+E-readers')]"));
		jsUtil.clickElementByJS(kindleElement);
		Thread.sleep(3000);
		
		//Set Input or do sendkeys using JS
		jsUtil.goBackByJS();
		Thread.sleep(3000);
		jsUtil.scrollPageUp();
		Thread.sleep(3000);
		jsUtil.sendKeysUsingIdByJS("twotabsearchtextbox", "iPhone12");
		
	}

}
