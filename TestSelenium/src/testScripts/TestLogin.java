package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class TestLogin {
	
	private WebDriver  driver;
	private String  baseUrl="http://localhost:8080";
	
	@Test
	public void testLogin() throws InterruptedException{
		driver.get(baseUrl);
		LoginPage  loginpage = new LoginPage(driver);
		
		loginpage.email.sendKeys("test1@chinarun.com");
		loginpage.password.sendKeys("123456");
		loginpage.loginButton.click();
		//等待5秒
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("上海自由博爱"));
	}
	
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver();
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
}
