package untils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLearn {
		
	@DataProvider(name="user")
	public Object[][] Users(){
		return new Object[][] {
			{"root","password"},
			{"cnbologs.com","tankxiao"},
			{"tank","zbz"}
		};
	}
	@Test(dataProvider="user")
		public void verifyUser(String username,String password){
			System.out.println("username:" +username +"Password:" +password);
		}
	@Test(enabled=false)
	public void testIngore(){
		System.out.println("this test case will ignore");
	}
}
