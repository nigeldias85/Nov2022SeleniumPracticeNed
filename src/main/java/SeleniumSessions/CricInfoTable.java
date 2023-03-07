package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CricInfoTable {

	static RemoteWebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/sa20-2022-23-1335268/mi-cape-town-vs-pretoria-capitals-20th-match-1343960/full-scorecard");
		Thread.sleep(4000);
		
		//String wicketTaker = driver.findElement(By.xpath("//span[contains(text(), 'Will Jacks')]/ancestor::td/following-sibling::td//span")).getText();
		//System.out.println("WicketTakers: "+wicketTaker);
		
		String wicketTaker = getWicketTaker("Will Jacks");
		wicketTaker = getWicketTaker("Theunis de Bruyn");
		
		List<String> willScoreList = getScorecardList("Will Jacks");
		System.out.println("WillJacksScoreCard: "+willScoreList);
	}
	
	
	public static String getWicketTaker(String batter) {
		String wicketTaker = driver.findElement(By.xpath("//span[contains(text(), '"+batter+"')]/ancestor::td/following-sibling::td//span")).getText();
		System.out.println("WicketTakers: "+wicketTaker);
		return wicketTaker;
	}
	
	public static List<String> getScorecardList(String batter) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//span[contains(text(), '"+batter+"')]/ancestor::td/following-sibling::td[contains(@class, 'ds-text-right')]"));
		List<String> playerScoreList = new ArrayList<String>();
		for(WebElement ele: scoreList) {
			String score = ele.getText();
			playerScoreList.add(score);
		}
		return playerScoreList;
	}

}
