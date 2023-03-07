package SeleniumSessions.PracticeTrials;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class ImplicitExplicitWaitTrial {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
//		doImplicitWait();

		// Click on View All Products
//		By viewAllProdLocator = By.xpath("//span[contains(text(), 'View all products')]");
//		driver.findElement(viewAllProdLocator).click();

		// Assert that we are on the page
//		By headlineTextLocator = By.xpath("//section[contains(@class, 'banner-default')]/div/h1");
//		String bannerText = driver.findElement(headlineTextLocator).getText();
//		System.out.println("BannerText: " + bannerText);
//		
//		doImplicitWait("https://reqres.in/api/users?delay=9");
		
		doExplicitWait();

	}
	
	public static void doExplicitWait() {
		driver.get("https://www.google.com");
		////div[@role='dialog']
//		WebElement frameElement = driver.findElement(By.xpath("//div[@role='dialog']"));
//		driver.switchTo().frame(frameElement);
//		By noThanksLocator = By.xpath("//button[contains(text(), 'No thanks')]");
//		driver.findElement(noThanksLocator).click();
//		if(driver.findElement(noThanksLocator).isDisplayed()) {
//			driver.findElement(noThanksLocator).click();
//		}
		driver.findElement(By.name("q")).sendKeys("crm tools" + Keys.ENTER);
		//href="https://www.salesforce.com/in/form/sem/crm-systems/"
		By sfLinkLocator = By.xpath("//a[contains(@href, 'salesforce.com')]");
		WebElement ele= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(sfLinkLocator));
		System.out.println("Text: "+ele.getText());
	}

	public static void doImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.freshworks.com/");
		closeCookies();
		driver.findElement(By.id("persona_product_menu_v2")).click();
		List<WebElement> personalProdList = driver.findElements(By.xpath("//div[@class='persona-product-card']/h2"));
		System.out.println("Size: " + personalProdList.size());
		for (WebElement ele : personalProdList) {
			System.out.println(ele.getText());
		}
	}

	public static void doImplicitWait(String url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		System.out.println(driver.getPageSource());
	}

	public static void closeCookies() {
		By acceptCookiesLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
		if (driver.findElement(acceptCookiesLocator).isDisplayed())
			driver.findElement(acceptCookiesLocator).click();
	}

}
