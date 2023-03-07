package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
	
	
	//Global PreConditions
	//pre condition
	//test cases --> test steps --> Actual versus Expected/Assertions
	//post steps
	//post global steps
	
	//Sequence of run
//	BS - startDbConnection
//	BT - createUser
//	BC - launchBrowser
	
//	BM - loginToApp
//	homePageSearchTest
//	AM - logout
	
//	BM - loginToApp
//	homePageTitleTest
//	AM - logout
	
//	BM - loginToApp
//	homePageUrlTest
//	AM - logout
	
//	AC - closeBrowser
//	AT - deleteUser
//	AS - disconnectDbConnection
	
	
	
	//1 Preferance
	@BeforeSuite
	public void startDbConnection() {
		System.out.println("BS - startDbConnection");
	}
	
	//2 Preferance
	@BeforeTest
	public void createUser() {
		System.out.println("BT - createUser");
	}
	
	
	//3
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC - launchBrowser");
	}
	
	//4 7 10
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM - loginToApp");
	}
	
	
	//8
	@Test
	public void homePageTitleTest() {
		System.out.println("homePageTitleTest");
	}
	
	
	//11
	@Test
	public void homePageUrlTest() {
		System.out.println("homePageUrlTest");
	}
	
	
	//5
	@Test
	public void homePageSearchTest() {
		System.out.println("homePageSearchTest");
	}
	
	
	//6 9 12
	@AfterMethod
	public void logout() {
		System.out.println("AM - logout");
	}
	
	
	//13
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - closeBrowser");
	}
	
	
	//14
	@AfterTest
	public void deleteUser() {
		System.out.println("AT - deleteUser");
	}
	
	
	//15
	@AfterSuite
	public void disconnectDbConnection() {
		System.out.println("AS - disconnectDbConnection");
	}

}
