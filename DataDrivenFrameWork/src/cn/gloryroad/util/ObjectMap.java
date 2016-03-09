package cn.gloryroad.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties  properties;
	//从配置文件中读取定位元素的方式及相应的值
	public ObjectMap(String propFile){
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("读取对象失败");
			e.printStackTrace();
		}

	}
	
	public By getLocator(String ElementNameInproFile) throws Exception{
		//根据ElementNameInpropFile 从属性配置文件种读取对应的配置对象
		String locator = properties.getProperty(ElementNameInproFile);
		String locatorType = locator.split(">")[0];
		System.out.println(locator);
		String locatorValue = locator.split(">")[1];
		
		//使用getbytes 方法可以将字符串编码转化为utf-8 编码，以此来配置文件中文为乱码的问题
		 locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		 System.out.println("获取的定位了类型："+locatorType+"\t 获取的定位表达式"+locatorValue);
		 //根据locatortype 变量值内容判断何种定位方式的by对象
		  if (locatorType.toLowerCase().equals("id")){
			  return By.id(locatorValue);
		  }else if(locatorType.toLowerCase().equals("name")){
			  return By.name(locatorValue);
		  } else if(  (locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")) ){
			  return By.className(locatorValue);
		  } else if( (locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag"))){
			  return By.tagName(locatorValue);
		  } else if( (locatorType.toLowerCase().equals("linktext"))|| (locatorType.toLowerCase().equals("link"))){
			  return By.linkText(locatorValue);
		  } else if(locatorType.toLowerCase().equals("partiallinktext")){
			  return By.partialLinkText(locatorValue);
		  } else if( (locatorType.toLowerCase().equals("cssselector"))||(locatorType.toLowerCase().equals("css"))){
			  return By.cssSelector(locatorValue);
		  } else if( locatorType.toLowerCase().equals("xpath")){
			  return By.xpath(locatorValue);
		  }else{
			  throw new Exception("输入的locator type 未在程序种被定义："+ locatorType);
		  }
	}
	
}
