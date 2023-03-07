package testngsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartHomePageTest extends BaseTest{
	
	public void doSearch(String input) {
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(input);
		driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();
	}
	
	public List<WebElement> getSearchResults() {
		List<WebElement> searchResultList = driver.findElements(By.xpath("//h2[text()='Products meeting the search criteria']/following-sibling::div/following-sibling::div//div[@class='caption']"));
		return searchResultList;
	}
	
	public List<WebElement> getProductNames() {
		List<WebElement> productList = driver.findElements(By.xpath("//h2[text()='Products meeting the search criteria']/following-sibling::div/following-sibling::div//div[@class='caption']/h4/a"));
		return productList;
	}
	
	
	public List<WebElement> getProductPrices() {
		List<WebElement> productPriceList = driver.findElements(By.xpath("//h2[text()='Products meeting the search criteria']/following-sibling::div/following-sibling::div//div[@class='caption']/p[@class='price']"));
		return productPriceList;
	}
	
	public List<String> buildExpectedProdNames() {
		List<String> productList = new ArrayList<>();
		productList.add("MacBook");
		productList.add("MacBook Air");
		productList.add("MacBook Pro");
		return productList;
	}
	
	public List<String> buildExpectedProdPrices() {
		List<String> productPricesList = new ArrayList<>();
		productPricesList.add("$602.00");
		productPricesList.add("$1,202.00");
		productPricesList.add("$2,000.00");
		return productPricesList;
	}
	
	public List<String> buildExpectedProdPricesExTax() {
		List<String> productPricesList = new ArrayList<>();
		productPricesList.add("$500.00");
		productPricesList.add("$1,000.00");
		productPricesList.add("$2,000.00");
		return productPricesList;
	}
	
	
	@Test
	public void searchForMacbookTest() {
		
		doSearch("macbook");
		//Validate number of products
		System.out.println("The Search Results are: "+getSearchResults().size());
		Assert.assertTrue(getSearchResults().size() == 3);
	}
	
	@Test
	public void validateProductNames() {
		
		List<WebElement> productNamesList = getProductNames();
		List<String> expectedProdList = buildExpectedProdNames();
		for(int i=0; i<expectedProdList.size(); i++) {
			String expectedValue = expectedProdList.get(i);
			String actualValue = productNamesList.get(i).getText().trim();
			System.out.println("Comparing expected value: "+expectedValue+" with actual value: "+actualValue);
			Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
		}
		System.out.println("");
		System.out.println("");
	}
	
	
	@Test
	public void validateProductPrices() {
		
		List<WebElement> productPricesList = getProductPrices();
		List<String> expectedProdPriceList = buildExpectedProdPrices();
		List<String> expectedProdPricExTaxList = buildExpectedProdPricesExTax();
		for(int i=0; i<expectedProdPriceList.size(); i++) {
			//Validating prices with tax
			String expectedValue = expectedProdPriceList.get(i);
			String actualValue = productPricesList.get(i).getText().trim();
			String[] actualValues = actualValue.split("Ex Tax:");
			String actualValueWithTax = actualValues[0].trim();
			System.out.println("Comparing expected value: "+expectedValue+" with actual value: "+actualValueWithTax);
			Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValueWithTax));
			
			//Validating prices without tax
			expectedValue = expectedProdPricExTaxList.get(i);
			String actualValueWithoutTax = actualValues[1].trim();
			System.out.println("Comparing expected value: "+expectedValue+" with actual value: "+actualValueWithoutTax);
			Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValueWithoutTax));
			System.out.println("");
			System.out.println("");
		}
	}
	

}
