package untils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGLearn {

	@BeforeClass
	public void beforeClass(){
		System.out.println("this is before class");
	}
	@Test
	public void TestNgLearn(){
		System.out.println("this is TestNG test case");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("this is after class");
	}
	
	@Test(expectedExceptions =IllegalArgumentException.class,expectedExceptionsMessageRegExp="NullPoint")
	public void testException(){
		throw new IllegalArgumentException("NullPoint");
	}
}
