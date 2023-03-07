package testngsessions;

import org.testng.annotations.Test;

public class CRUDOperationTest {
	
	
	public void createUser() {
		System.out.println("Create User");
	}
	
	
	public void getUser() {
		System.out.println("Get User");
	}
	
	
	public void updateUser() {
		System.out.println("Update User");
	}
	
	
	public void deleteUser() {
		System.out.println("User Deleted");
	}
	
	
	@Test
	public void createUserTest() {
		createUser();
	}
	
	
	@Test
	public void getUserTest() {
		createUser();
		getUser();
	}
	
	
	@Test
	public void updateUserTest() {
		createUser();
		getUser();
		updateUser();
		getUser();
	}
	
	
	@Test
	public void deleteUserTest() {
		createUser();
		getUser();
		deleteUser();
		getUser();
	}
	
	

}
