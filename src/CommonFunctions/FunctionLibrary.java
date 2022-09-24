package CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import Config.AppUtil;

public class FunctionLibrary extends AppUtil
{
//method for login
	public static boolean verifyLogin(String username,String password)throws Throwable
	{
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(config.getProperty("ObjUser"))).sendKeys(username);
		driver.findElement(By.xpath(config.getProperty("ObjPass"))).sendKeys(password);
		driver.findElement(By.xpath(config.getProperty("ObjLogin"))).submit();
		String expected = "dashboard";
		String Actual = driver.getCurrentUrl();
	if(Actual.contains(expected))
	{
	Reporter.log("login success:::"+expected+" "+Actual,true);
	return true;
	}
	else
	{
	//capture the error message	
		String errormessage = driver.findElement(By.xpath(config.getProperty("ObjErrorMessage"))).getText();
		Reporter.log(errormessage+" "+expected+" "+Actual,false);
		return false;
	}
	}
}
