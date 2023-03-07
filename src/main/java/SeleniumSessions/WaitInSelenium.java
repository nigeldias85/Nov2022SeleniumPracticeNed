package SeleniumSessions;

public class WaitInSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Types of Wait
		//1.Static Wait 
		//Thread.sleep(5000); -> Pause for 5 seconds
		
		//2.Dynamic Wait
		//Wait for 10 seconds , Element found in 2 seconds, Dont wait for 8 seconds.
		
		//2.a Implicilty Wait --> This is a Global Wait
		
		//2.b Explicitly Wait --> This is wait for certain elements + polling/interval time
			//2.b.i -> WebDriver Wait
			//2.b.ii -> Fluent Wait

		//Wait(I) --> This contain until method.
			//FluentWait(c)  --> Until Method Implemented here ,along with other methods are defined.
				//WebDriverWait(C)
	}

}
