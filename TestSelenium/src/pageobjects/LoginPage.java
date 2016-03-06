package pageobjects;

import org.openqa.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

	
	//使用FindBy 进行定位
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(xpath="//input[@value='登录']")
	public WebElement loginButton;
	
	
	String baseUrl = "http://localhost:8080";
	public WebDriver  driver; 
	//构造函数，声称浏览器对象，初始化pageFactory
	
	public LoginPage(WebDriver driver){
		setDriver(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver getDriver(){
		return driver;
	}
	

	//被访问测试网址的封装方法
	public void load(){
		driver.get(baseUrl);
	}
	
	//关闭浏览器窗口
	public void quit(){
		driver.quit();
	}
	//登录操作的封装方法
	public void login(){
	 email.sendKeys("test1@chinarun.com");
	 password.sendKeys("123456");
     loginButton.click();
	}
	
	
}
