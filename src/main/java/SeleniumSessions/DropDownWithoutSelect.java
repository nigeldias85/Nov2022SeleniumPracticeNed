package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelect {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By countryOptions = By.xpath("//select[@id='Form_getForm_Country']/option");
		List<WebElement> optionsList = driver.findElements(countryOptions);
		System.out.println("Size: "+optionsList);
		
		for(WebElement ele: optionsList) {
			if(ele.getText().equals("United Kingdom")) {
				ele.click();
				break;
			}
		}
	}

}
