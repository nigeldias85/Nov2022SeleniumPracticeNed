package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTests {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		By googleSearchLocator = By.name("q");
		driver.findElement(googleSearchLocator).sendKeys("Naveen Automation Labs");
		Thread.sleep(3000);

		By googleSuggestionLocator = By.xpath("//li[@role='presentation']//div[@class='wM6W7d']/span");
//		List<WebElement> searchSuggestionsList = driver.findElements(googleSuggestionLocator);
//		System.out.println(searchSuggestionsList.size());

		// Print all the suggestions
//		for(WebElement ele: searchSuggestionsList) {
//			System.out.println(ele.getText());
//		}

		// Click on a specific suggestion
//		for(WebElement ele: searchSuggestionsList) {
//			if(ele.getText().contains("youtube")) {
//				ele.click();
//				break;
//			}
//		}

		// search for "naveen automation labs youtube"
		boolean printAllSuggestions = false;
		doSearch(googleSuggestionLocator, "naveen automation labs youtube", printAllSuggestions);

	}

	public static void doSearch(By googleSuggestionLocator, String googleSearchSuggestionName,
			boolean printAllSuggestions) {

		List<WebElement> searchSuggestionsList = driver.findElements(googleSuggestionLocator);
		System.out.println(searchSuggestionsList.size());

		// Print all the suggestions
		if (printAllSuggestions) {
			for (WebElement ele : searchSuggestionsList) {
				String suggestion = ele.getText();
				if(suggestion.length() > 0) {
					System.out.println(ele.getText());
				}
			}
		}

		// Click on a specific suggestion
		for (WebElement ele : searchSuggestionsList) {
			System.out.println(ele.getText());
			if (ele.getText().contains(googleSearchSuggestionName)) {
				ele.click();
				break;
			}
		}
	}

}
