package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.gloryroad.util.ObjectMap;

public class AddressBookPage {
		private WebElement element = null;
		private ObjectMap objectMap = new ObjectMap("/Users/zhangbingzhen/java_dev/DataDrivenFrameWork/objectMap.properties");
		private WebDriver driver;
		
		public AddressBookPage( WebDriver driver){
			this.driver =driver;
		}
		//获取添加联系人
		public WebElement createContactPersonButton() throws Exception{
			element = driver.findElement(objectMap.getLocator("126mail.addressbook.createContactPerson"));
			return element;
		}
		//获取新建联系人姓名输入框
		public WebElement contactPersonName() throws Exception{
			element = driver.findElement(objectMap.getLocator("126.mail.addressbook.contactPersonName"));
			return element;
		}
		//获取新建联系人电子邮箱输入框
		public WebElement contactPersonEmail() throws Exception{
			element = driver.findElement(objectMap.getLocator("126.mail.addressbook.contactPersonEmail"));
			return element;
		}
		//获取新建联系人移动电话
		public WebElement contactPersonMobile() throws Exception{
			element = driver.findElement(objectMap.getLocator("126.mail.addressbook.contactPersonMoblie"));
			return element;
		}
		//获取新建联系人的保存按钮
		public WebElement contactSaveButton() throws Exception{
			element = driver.findElement(objectMap.getLocator("126.mail.addressbook.contactSaveButton"));
			return element;
		}
		
		
		
		
		
}
