package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// TODO Auto-generated method stub

		By languageLinkLocator = By.xpath("//div[@id='SIvCob']/a");

//		List<WebElement> languageLinkList = driver.findElements(languageLinkLocator);
//		System.out.println("Size: "+languageLinkList.size());
//		System.out.println("Languages are...");
//		for(WebElement ele: languageLinkList) {
//			System.out.println(ele.getText());
//			if(ele.getText().equals("मराठी")) {
//				ele.click();
//				break;
//			}
//		}

		//Get Language Links
		List<String> languageNamesList = getGoogleLanguageNamesList(languageLinkLocator);
		System.out.println("LanguagesSize: " + languageNamesList.size());
		System.out.println(languageNamesList);
		
		//Click on a specific language
		clickGoogleLanguageLink(languageLinkLocator, "ಕನ್ನಡ");

	}

	public static List<String> getGoogleLanguageNamesList(By locator) {
		List<WebElement> languageLinkList = driver.findElements(locator);
		List<String> languagesList = new ArrayList<String>();
		for (WebElement ele : languageLinkList) {
			String languageName = ele.getText();
			System.out.println(languageName);
			languagesList.add(languageName);
		}
		return languagesList;
	}

	public static void clickGoogleLanguageLink(By locator, String expectedLanguageName) {
		List<WebElement> languageLinkList = driver.findElements(locator);
		for (WebElement ele : languageLinkList) {
			if(ele.getText().equals(expectedLanguageName)) {
				ele.click();
				break;
			}
		}
	}

}
