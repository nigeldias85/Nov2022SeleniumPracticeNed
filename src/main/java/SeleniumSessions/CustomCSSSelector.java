package SeleniumSessions;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		
		//id
		//#id
		//For eg: #input-firstname
		By fnLocator = By.cssSelector("#input-firstname");
		
		//tag#id
		//input#input-firstname
		
		
		//class
		//.class
		//.login-email
		//tag.class
		//input.login-email
		//.C1.C2.....Cn
		//tag.C1.C2.....Cn
		//For eg: input.form-control
		//The order of classes is not required.
		//It can be written as: tag.C3.C2.C4.C1.....Cn
		//For eg: input.form-control.private-form__control.login-email 
		
		//tag#id.class
		//For eg: input#username.login-email
		//tag.class#id
		//For eg: input.login-email#username
		//#id.class
		//.class#id
		//tag#id.C1.C2.C3....... Cn
		//For eg: input#username.form-control.private-form__control.login-email
		
		
		//Other Attributes : Other than ID and Class
		// input[type='text'] --- CSS
		// //input[@type='text'] --- XPATH
		
		//For eg: Using ID 
		// input[id='username']
		// input[class='<classname>'] --- WILL ONLY WORK WHEN THERE IS ONE CLASS, WILL NOT WORK FOR MULTIPLE CLASSES
		// input[class='form-control private-form__control login-email'] --- THIS WILL WORK
		
		
		// input[class='<classname>']  ---- css
		// input[@class='<classname>']  ---- XPATH
		
		
		//Multiple Attributes
		//tag[attr1='value1'][attr2='value2']
		//For eg: input[type='text'][placeholder='First Name'][name='firstname']
		//  input[type='text'][placeholder='First Name'][name='firstname'] --- CSS
		//  //input[@type='text' and @placeholder='First Name' and @name='firstname'] --- XPATH
		
		
		//tag#id[attr1='value1']
		//For eg: input#input-firstname[placeholder='First Name'][type='text']
		
		//tag#id[attr1='value1'].class
		//For eg: input#input-firstname[placeholder='First Name'][type='text'].form-control
		
		//h1[text()='Register Account']
		//text() CANNOT BE USED IN css selector
		
		//CONTAINS IN css
		//tag[atrr1*='value']
		//For eg: input[placeholder*='First']  //TO BE READ AS ATRRIBUTE(PLACEHOLDER) CONTAINS THE STRING 'first'
		//For eg: input[class*='login-email']  //TO BE READ AS ATRRIBUTE(CLASS) CONTAINS THE STRING 'login-email'
		
		//STARTS-WITH IN css
		//tag[atrr1^='value']
		//For eg:  input[placeholder^='First'] // TO BE READ AS ATTRIBUTE(PLACEHOLDER) START WITH 'First'
		
		//ENDS-WITH IN CSS
		//tag[atrr1$='value']
		//For eg: input[placeholder$='Name'] // TO BE READ AS ATTRIBUTE(PLACEHOLDER) ENDS WITH 'Name'
		
		
		//Parent To Child
		//parent tag child tag --- SPACE MEANS GET ALL DIRECT & INDIRECT CHILD(Direct + Indirect)
		//parent tag > child tag --- > MEANS GET ALL DIRECT CHILD (Direct)
		
		//For eg: div.private-form__input-wrapper input#username
		
		//For eg: form#Form_getForm select //Get me all the Select(direct or indirect) within form
	
		
		//For eg: form#hs-login > div  //GET ALL THE DIRECT DIV TAG'S WITHIN THE FORM
		//For eg: form#hs-login  div //GET ALL THE DIRECT & INDIRECT DIV TAG'S WITHIT THE FORM
		
		
		//Child to Parent in CSS -- NOT POSSIBLE
		//text() function in CSS -- NOT POSSIBLE
	
		
		//Using OR in CSS selector
		//input#username,button#loginBtn,input#password,button#ssoBtn
		List<WebElement> appHubSpotLoginElementsList =
				driver.findElements(By.cssSelector("input#username,button#loginBtn,input#password,button#ssoBtn"));
		int impFieldsCount = appHubSpotLoginElementsList.size();
		
		if(impFieldsCount == 4) {
			//Do some assertion
			System.out.println("PASS");
		}
		
		
		//Not in CSS
		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		
		//Select's only username
		//not is used to signify that: "Do not include password"
		//input.form-control.private-form__control:not(#password)
		
		//Get all the inputs fields from open cart app -> register page
		//Get all input fields except for search field.
		//input.form-control:not(input[name='search'])
		
		//Get all input fields except for search field and password fields
		//input.form-control:not(input[name='search'], input[type='password'])
		
		
		//Indexing in CSS
		//Get first child from the country dropdown(select) in orangehrm.com
		//select#Form_getForm_Country>option:first-child
		//select#Form_getForm_Country>option:first-of-type
		
		//Get last child from the country dropdown(select) in orangehrm.com
		//select#Form_getForm_Country>option:last-child
		//select#Form_getForm_Country>option:last-of-type
		
		//Get the first/last child within the select tag
		//select#Form_getForm_Country>:first-child
		//select#Form_getForm_Country>:last-child
		
		//Get the drop down value for the option tag, corresponding to 53rd element
		//This follows a indexing starting from 1
		//select#Form_getForm_Country>option:nth-of-type(53)
		//select#Form_getForm_Country>:nth-of-type(53)
		
		
		//SIBLING in CSS
		//Access following sibling in CSS
		//label[for='input-email']+input
		//label[for='input-email']+input[name='email']
		
		//Get all the following siblings from div which has class: private-form__label-wrapper
		//div.private-form__label-wrapper~div
		// + means immediate sibling -> 1 immediate sibling
		// ~ means all the siblings that follow -> All following siblings
		
		
		//xpath versus css
							//xpath				versus					css
		//1.Syntax:			Complex										Simple
		//2.text()			Yes											No
		//3.AND 			Yes											Yes
		//4.OR				Yes											Yes , comma
		//5.Forward 		Yes											Yes
		//6.Backward		Yes											No
		//7.Fwd Sibling		Yes											Yes
		//8.Bckwd Sibling	Yes											No
		//9.Not				No											Yes
		//10.Indexing		Yes											Yes
		//11. Capture Group	Yes											No
		//12.Perf			Good										Good
		//13.StartsWith		Yes											Yes
		//14.Contains		Yes											Yes
		//15.EndsWith		No											Yes
		//16.WebTable 		Yes											Limited Options
		
		
	}

}
