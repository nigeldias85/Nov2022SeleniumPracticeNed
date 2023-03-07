package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browserName = "firefox";
		BrowserUtil browserUtil = new BrowserUtil();
		WebDriver driver = browserUtil.initDriver(browserName);
		
		//Launch Reg Page Url
		browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//Print the page title
		System.out.println(browserUtil.getPageTitle());
		
		//Create Locator and set the value
		By firstNameLocator = By.id("input-firstname");
		ElementUtil elementUtil = new ElementUtil(driver);
		elementUtil.doSendKeys(firstNameLocator, "Allen");
		
		By lastNameLocator = By.id("input-lastname");
		elementUtil.doSendKeys(lastNameLocator, "Solly");
		
		By emailLocator = By.id("input-email");
		elementUtil.doSendKeys(emailLocator, "allen.solly@gmail.com");
		
		By telephoneLocator = By.id("input-telephone");
		elementUtil.doSendKeys(telephoneLocator, "919898098980");
		
		By passwordLocator = By.id("input-password");
		elementUtil.doSendKeys(passwordLocator, "welcome@123");
		
		By passwordConfirmLocator = By.id("input-confirm");
		elementUtil.doSendKeys(passwordConfirmLocator, "welcome@123");
		
		
		
		
		
		
		
		
		
		

	}

}
