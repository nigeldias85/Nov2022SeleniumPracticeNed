package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAttribute {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		// List<WebElement> linksList = driver.findElements(By.tagName("a"));
		By linksLocator = By.tagName("a");
		List<WebElement> linksList = getElements(linksLocator);
		System.out.println("LinksCount: " + linksList.size());
		By imgLocator = By.tagName("img");
		List<WebElement> imgList = getElements(imgLocator);
		System.out.println("ImagesCount: " + imgList.size());

		int index = 0;
//		for(WebElement ele: linksList) {
//				index++;
//				System.out.println("href"+index+" : "+ele.getAttribute("href"));
//				System.out.println("linkText"+index+" : "+ele.getText());
//				System.out.println("");
//		}
		getElementAttributes(linksLocator, "href");

//		index = 0;
//		for (WebElement ele : imgList) {
//			index++;
//			System.out.println("src" + index + " : " + ele.getAttribute("src"));
//		}
		
		System.out.println("");
		getElementAttributes(imgLocator, "src");
	}

	public static void getElementAttributes(By locator, String attribute) {
		List<WebElement> elementList = getElements(locator);
		for (WebElement ele : elementList) {
			System.out.println(ele.getAttribute(attribute));
		}
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
