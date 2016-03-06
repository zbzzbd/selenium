package untils;

import org.testng.annotations.Test;

public class GroupTest {
	@Test(groups = {"systemtest"})
	public void testLogin(){
		System.out.println("this is login");
	}
	@Test(groups = {"functiontest"}) 
	public void testOpenPage(){
		System.out.println("this is open page");
	}
}
