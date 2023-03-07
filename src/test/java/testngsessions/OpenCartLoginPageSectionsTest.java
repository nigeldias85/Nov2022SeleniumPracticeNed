package testngsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartLoginPageSectionsTest extends BaseTest {
	
	
	public String getNewCustomerBlockTitle() {
		return driver.findElement(By.xpath("//div[@class='well']/h2[contains(text(), 'New')]")).getText();
	}
	
	public String getNewCustomerSectionName() {
		return driver.findElement(By.xpath("//div[@class='well']/p/strong[contains(text(), 'Register')]")).getText();
	}
	
	public String getNewCustomerDetailedText() {
		return driver.findElement(By.xpath("//div[@class='well']/p[contains(text(), 'creating an account')]")).getText().trim();
	}
	
	public List<WebElement> getAllMenuOptions() {
		List<WebElement> menuOptionsList = driver.findElements(By.xpath("//div[@class='list-group']/a"));
		return menuOptionsList;
	}
	
	public List<String> buildExpectedMenuOptions() {
		List<String> expectedMenuOptionsList = new ArrayList<>();
		expectedMenuOptionsList.add("Login");
		expectedMenuOptionsList.add("Register");
		expectedMenuOptionsList.add("Forgotten Password");
		expectedMenuOptionsList.add("My Account");
		expectedMenuOptionsList.add("Address Book");
		expectedMenuOptionsList.add("Wish List");
		expectedMenuOptionsList.add("Order History");
		expectedMenuOptionsList.add("Downloads");
		expectedMenuOptionsList.add("Recurring payments");
		expectedMenuOptionsList.add("Reward Points");
		expectedMenuOptionsList.add("Returns");
		expectedMenuOptionsList.add("Transactions");
		expectedMenuOptionsList.add("Newsletter");
		return expectedMenuOptionsList;
	}
	
	
	@Test
	public void newCustomerBlockTest() {
		System.out.println("Validating New Customer Block");
		Assert.assertTrue(getNewCustomerBlockTitle().trim().equalsIgnoreCase("New Customer"));
		Assert.assertTrue(getNewCustomerSectionName().trim().equalsIgnoreCase("Register Account"));
		String expectedValue = "By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.";
		Assert.assertTrue(getNewCustomerDetailedText().equalsIgnoreCase(expectedValue));
		
	}
	
	
	@Test
	public void menuOptionsListTest() {
		System.out.println("Validating Menu Options");
		List<WebElement> menuOptionsList = getAllMenuOptions();
		List<String> expectedMenuOptionsList = buildExpectedMenuOptions();
		for(int i=0; i< expectedMenuOptionsList.size(); i++) {
			String expectedValue = expectedMenuOptionsList.get(i);
			String actualValue = menuOptionsList.get(i).getText().trim();
			System.out.println("Comparing expected value: "+expectedValue+" with actual value: "+actualValue);
			Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
		}
	}

}
