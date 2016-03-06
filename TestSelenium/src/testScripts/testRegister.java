package testScripts;

import org.openqa.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class testRegister {

	
	//使用Find
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(xpath="//input[@value='登录']")
	public WebElement loginButton;
	
	 
}
