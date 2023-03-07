package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		By footerLocator = By.cssSelector("footer a");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//List<WebElement> footerElementsList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footerLocator));
		List<WebElement> footerElementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerLocator));
		System.out.println("FooterSize: "+footerElementsList.size());
		
		
	}

}
