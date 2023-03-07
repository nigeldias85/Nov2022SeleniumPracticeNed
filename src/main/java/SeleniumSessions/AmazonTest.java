package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browserName = "Firefox";
		
		BrowserUtil brUtil = new BrowserUtil();
		
		//Initialize Driver and launch the url
		brUtil.initDriver(browserName);
		brUtil.launchUrl("https://www.amazon.com");
		
		//Get the page title
		String actualTitle = brUtil.getPageTitle();
		if(actualTitle.contains("Amazon"))
			System.out.println("Title test case is passed");
		else 
			System.out.println("Title test case is failed");

		//Get page Url
		String actualPageUrl = brUtil.getPageUrl();
		if(actualPageUrl.contains("amazon"))
			System.out.println("Url test case is passed");
		else 
			System.out.println("Url test case is failed");
		
		//close the browser
		brUtil.quitBrowser();

	}

}
