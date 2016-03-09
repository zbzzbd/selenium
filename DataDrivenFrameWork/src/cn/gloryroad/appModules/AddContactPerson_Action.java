package cn.gloryroad.appModules;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cn.gloryroad.pageObjects.AddressBookPage;
import cn.gloryroad.pageObjects.HomePage;

public class AddContactPerson_Action {
	
	public static void execute(WebDriver driver,String userName,String password,String contactName,String contactEmail,String contactMobile) throws Exception{
		//登录
		Login_Action.execute(driver, userName, password);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("收信"));
		//进入主页,点击通讯录按钮
		HomePage homePage = new HomePage(driver);
		homePage.addressLink().click();
		
		//添加通讯录
		AddressBookPage addressBookPage = new AddressBookPage(driver);
		Thread.sleep(3000);
		addressBookPage.createContactPersonButton().click();//点击添加联系人
		Thread.sleep(1000);
		addressBookPage.contactPersonName().sendKeys(contactName);
		addressBookPage.contactPersonEmail().sendKeys(contactEmail);
		addressBookPage.contactPersonMobile().sendKeys(contactMobile);
		addressBookPage.contactSaveButton().click();
		Thread.sleep(5000);
	}
	
}
