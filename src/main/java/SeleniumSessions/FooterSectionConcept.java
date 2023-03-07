package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterSectionConcept {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		List<WebElement> footerSectionList =  driver.findElements(By.xpath("//h5[text()='Information']/following-sibling::ul/li"));
		System.out.println("Size: "+footerSectionList.size());
		
//		for(WebElement ele: footerSectionList) {
//			System.out.println("Text: "+ele.getText());
//		}
		
		List<String> infoList = getFooterSectionList("Information");
		System.out.println(infoList);
		
		System.out.println("");
		List<String> myAccountList = getFooterSectionList("My Account");
		System.out.println(myAccountList);
	}
	
	
	public static List<String> getFooterSectionList(String sectionName) {
		List<WebElement> footerSectionList =  driver.findElements(By.xpath("//h5[text()='"+sectionName+"']/following-sibling::ul/li"));
		System.out.println("Size: "+footerSectionList.size());
		List<String> footerSectionValuesList = new ArrayList<String>();
		for(WebElement ele: footerSectionList) {
			System.out.println("Text: "+ele.getText());
			footerSectionValuesList.add(ele.getText());
		}
		return footerSectionValuesList;
	}

}
