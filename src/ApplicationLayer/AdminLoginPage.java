package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage
{
//define repository for page events
	@FindBy(name="txtUsername")
	WebElement ObjUser;
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement ObjPass;
	@FindBy(id="btnLogin")
	WebElement ObjLogin;
	//write methods
	public void VerifyLogin(String username,String password)
	{
		ObjUser.sendKeys(username);
		ObjPass.sendKeys(password);
		ObjLogin.submit();
	}
}
