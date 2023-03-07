package SeleniumSessions.PracticeTrials;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WindowsSwitchingTrials {
	static RemoteWebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		
		String url = "https://app.hubspot.com/login";
		driver.get(url);
		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent: "+parentWindowId);
		
		//Open the footer links
		driver.findElement(By.xpath("//a[contains(@href, 'privacy-policy')]")).click();
		
		//Get all the window handles
		Set<String> hSet = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(hSet);
		System.out.println("Size: "+hList.size());
		
		//Switch to new window
		if(switchToRightWindow("Privacy Policy" , hList)) {
			System.out.println(driver.getCurrentUrl() + " :" +driver.getTitle());
		}
		
		//Close the other windows
		closeAllWindows(hList, parentWindowId);
		
		//Switch back to parent window
		switchToParentWindow(parentWindowId);
		System.out.println("ParentWindow: "+driver.getCurrentUrl());
		System.out.println("ParentWindow: "+driver.getTitle());
		
		

	}
	
	public static void closeAllWindows(List<String> hList, String parentWindowId) {
		
		for(String ele: hList) {
			if(!ele.equals(parentWindowId)) {
				driver.switchTo().window(ele).close();
			}
		}
	}
	
	public static void switchToParentWindow(String parentWindowId) {
		driver.switchTo().window(parentWindowId);
	}
	
	public static boolean switchToRightWindow(String expTitle, List<String> hList) {
		for(String ele: hList) {
			String title = driver.switchTo().window(ele).getTitle();
			System.out.println("Title: "+title);
			if(title.contains(expTitle)) {
				System.out.println("Found the right window");
				return true;
			}
		}
		return false;
	}

}
