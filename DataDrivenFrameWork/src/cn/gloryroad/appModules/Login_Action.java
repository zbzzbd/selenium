package cn.gloryroad.appModules;

import org.openqa.selenium.WebDriver;

import cn.gloryroad.pageObjects.LoginPage;
import cn.gloryroad.util.Constant;

public class Login_Action {
	
	public static void execute(WebDriver driver,String userName,String password) throws Exception{
		
		driver.get(Constant.url);
		LoginPage  loginPage = new LoginPage(driver);
		loginPage.userName().sendKeys(userName);
		loginPage.password().sendKeys(password);
		loginPage.loginButton().click();
		Thread.sleep(5000);
	}
}
