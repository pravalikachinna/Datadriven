package DriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ApplicationLayer.AdminLoginPage;
import ApplicationLayer.AdminLogoutpage;
import ApplicationLayer.EmpPage;

public class TestScript 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
		login.VerifyLogin("Admin", "Qedge123!@#");	
	}
@Test
public void EmpCreation() throws Throwable 
{
	EmpPage emp=PageFactory.initElements(driver, EmpPage.class);
	boolean res=emp.verifyAddEmp("mmm", "nnn", "ddd");
	System.out.println(res);
}
@AfterTest
public void teardown()
{
	AdminLogoutpage logout=PageFactory.initElements(driver, AdminLogoutpage.class);
	logout.verifyLogout();
	driver.close();
}
}
