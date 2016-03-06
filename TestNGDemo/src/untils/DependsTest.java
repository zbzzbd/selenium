package untils;

import org.testng.annotations.Test;

public class DependsTest {
	@Test (enabled =true)
	public void setupEnv(){
		System.out.println("this is setup Env");
	}
	
	@Test(dependsOnMethods={"setupEnv"})
	public void testMessage(){
		System.out.println("this is test message");
	}
}
