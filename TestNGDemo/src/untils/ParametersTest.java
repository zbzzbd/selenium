package untils;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

	@Test
	@Parameters("test1")
	public void ParaTest(String test1) {
		System.out.println("this is " + test1);
	}
}
