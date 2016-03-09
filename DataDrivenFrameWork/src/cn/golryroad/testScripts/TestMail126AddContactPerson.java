package cn.golryroad.testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.gloryroad.appModules.AddContactPerson_Action;
import cn.gloryroad.util.Constant;
import cn.gloryroad.util.ExcelUtil;

public class TestMail126AddContactPerson {
	public WebDriver driver;
	String baseUrl = "http://exmail.qq.com/login";
	@BeforeClass
	public void beforeClass() throws Exception{
		DOMConfigurator.configure("log4j.xml");
	}
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@DataProvider(name="testData")
	public static Object[][] data() throws IOException{
		return ExcelUtil.getTestData(Constant.TestDataExcelFilePath, Constant.TestDataExcelFileSheet);
	}
	
	@Test(dataProvider="testData")
	public void testAddContactPesion(String CaseRowNumber,String testCaseName,
			String mailUserName,String mailPasswd,String contactPersonName,
			String contactPersonEmail,String contactPersonMobile,
			String assertContactPersonName,String assertContactPersonEmail,
			String assertContactPersonMobile) throws Exception{
		//调用Modules 封装的方法进行新建联系人
		AddContactPerson_Action.execute(driver,Constant.MailUsername, Constant.MailPassword, Constant.ContactPersonName,Constant.ContactPersonEmail, Constant.ContactPersonMobile);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains(Constant.ContactPersonName));
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
