package SeleniumSessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownAllElements {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By countryLocator = By.id("Form_getForm_Country");
		
//		Select select = new Select(driver.findElement(countryLocator));
//		List<WebElement> optionsList =  select.getOptions();
//		System.out.println("DropDownSize: "+optionsList.size()); 
		//IF we exclude default drop down value , then size = optionsList.size() -1 ;
		
		
//		for(WebElement ele: optionsList) {
//			String countryName = ele.getText();
//			System.out.println(countryName);
//			if(countryName.equals("United Kingdom")) {
//				ele.click();
//				break;
//			}
//		}
		
		//Get total countries list
		int CountriesCount = getTotalDropDownOptions(countryLocator);
		if(CountriesCount-1 == 232) {
			System.out.println("Country Drop Down Count is Correct");
		}
		
		//Get Countries Text List
		List<String> countriesList = getDropDownOptionsTextList(countryLocator);
		if(countriesList.contains("India")) {
			System.out.println("India is present");
		}
		
		List<String> expectedCountriesList =  Arrays.asList("Japan", "Canada", "France", "Ghana");
		if(countriesList.containsAll(expectedCountriesList)) {
			System.out.println("Countries: "+expectedCountriesList+" are present in the dropdown");
		}
		
		//Select a specific country without using selectByIndex, selectByValue, selectByVisibleText
		selectDropDownValue(countryLocator, "North Korea");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<String> getDropDownOptionsTextList(By locator) {
		List<WebElement> optionsList = getTotalDropDownOptionsList(locator);
		List<String> optionsTextList = new ArrayList<String>();
		for(WebElement ele: optionsList) {
			String countryName = ele.getText();
			optionsTextList.add(countryName);
		}
		return optionsTextList;
	}
	
	public static List<WebElement> getTotalDropDownOptionsList(By locator) {
		Select select = new Select(driver.findElement(locator));
		return select.getOptions();
	}
	
	public static int getTotalDropDownOptions(By locator) {
		int optionsCount =  getTotalDropDownOptionsList(locator).size();
		System.out.println("TotalOptionsCount: "+optionsCount);
		return optionsCount;
	}
	
	
	public static void selectDropDownValue(By locator, String expectedValue) {
		List<WebElement> optionsList = getTotalDropDownOptionsList(locator);
		for(WebElement ele: optionsList) {
			if(ele.getText().equals(expectedValue)) {
				ele.click();
				System.out.println(expectedValue +" is selected");
				break;
			}
		}
	}	
	

}
