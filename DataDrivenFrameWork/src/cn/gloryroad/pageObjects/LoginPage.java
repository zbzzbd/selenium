package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.gloryroad.util.ObjectMap;

public class LoginPage {
	private WebElement element = null;
	//指定配置文件的绝对路径
	private ObjectMap objectMap = new ObjectMap("/Users/zhangbingzhen/java_dev/DataDrivenFrameWork/objectMap.properties");
	private WebDriver dirver;
	
	public LoginPage(WebDriver driver){
		this.dirver =driver;
	}
	
	//返回登录页面中用户输入框页面元素对象 
	
	public WebElement userName() throws Exception{
		//使用objectmap 类种的getLocator 方法获取配置文件中关于用户的定位方式和定位表达式
		element = dirver.findElement(objectMap.getLocator("126mail.loginPage.username"));
		return element;
	}
	//返回登录页面中密码输入框的对象
	public WebElement password() throws Exception{
		element = dirver.findElement(objectMap.getLocator("126mail.loginPage.password"));
		return element;
	}
	//返回登录页面按钮元素对象
	public WebElement loginButton() throws Exception{
		element = dirver.findElement(objectMap.getLocator("126mail.loginPage.loginbutton"));
		return element;
	}
}
