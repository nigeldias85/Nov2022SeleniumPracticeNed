package testngsessions;

import org.testng.annotations.Test;

public class PriorityTest {

	
		//Without priority and with priority tests can be clubbed together
		//First non-priority tests will be run and picked up in alphabetical order
		//Next priority tests will be picked up
		//Order: -ve priority, 0, +ve priority
	
		
		@Test()
		public void a_test() {
			System.out.println("a test");
		}
		
		@Test()
		public void b_test() {
			System.out.println("b test");
		}
		
		@Test()
		public void c_test() {
			System.out.println("c test");
		}
		
		
		@Test(priority = 1)
		public void d_test() {
			System.out.println("d test");
		}
		
		
		@Test(priority = 2)
		public void e_test() {
			System.out.println("e test");
		}
		


}
