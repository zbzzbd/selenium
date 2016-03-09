package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.gloryroad.util.ObjectMap;

public class HomePage {
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap("/Users/zhangbingzhen/java_dev/DataDrivenFrameWork/objectMap.properties");
	private  WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	//获取登录侯主页中的“通讯录”链接
	public WebElement addressLink() throws Exception{
		element = driver.findElement(objectMap.getLocator("126mail.homePage.addressbook"));
		return element;
	}
	//如果要在homePage 页面中操作更过的元素，可以根据需要自定义
	
}
