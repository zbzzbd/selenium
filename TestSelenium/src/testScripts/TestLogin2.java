package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class TestLogin2 {

	public WebDriver driver;

	@Test
	public void testLogin() throws InterruptedException {
		// 生成一个loginpage 对象
		LoginPage loginpage = new LoginPage(new FirefoxDriver());
		// 调用登录页面对象的load 方法
		loginpage.load();
		loginpage.login();
		//等待5秒
		Thread.sleep(5000);
		
		Assert.assertTrue(loginpage.getDriver().getPageSource().contains("上海自由博爱"));
		loginpage.quit();
	}
}
