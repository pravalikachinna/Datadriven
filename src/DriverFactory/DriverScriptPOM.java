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
import Utilities.ExcelFileUtil;

public class DriverScriptPOM 
{
	WebDriver driver;
	String inputpath="C:\\Users\\Newpcworld\\eclipse-workspace\\DDT_Framework\\TestInput\\Employee.xlsx";
    String outputpath="C:\\Users\\Newpcworld\\eclipse-workspace\\DDT_Framework\\TestOutput\\EmpResults.xlsx";
@BeforeTest
public void setup()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	AdminLoginPage login=PageFactory.initElements(driver, AdminLoginPage.class);
	login.VerifyLogin("Admin", "Qedge123!@#");
}
@Test
public void startTest()throws Throwable
{
	ExcelFileUtil xl=new ExcelFileUtil(inputpath);
	int rc=xl.rowcount("EmpData");
	for(int i=1;i<=rc;i++)
	{
		String para1=xl.getcellData("EmpData", i, 0);
		String para2=xl.getcellData("EmpData", i, 1);
		String para3=xl.getcellData("EmpData", i, 2);
		EmpPage emp=PageFactory.initElements(driver, EmpPage.class);
		boolean res=emp.verifyAddEmp(para1, para2, para3);
		if(res)
		{
			xl.setcelldata("EmpData", i, 3, "pass", outputpath);                                 
		}
		else
		{
			
			xl.setcelldata("EmpData", i, 3, "fail", outputpath);	
		}		
		}
	}
@AfterTest
public void teardown(){
	AdminLogoutpage logout=PageFactory.initElements(driver, AdminLogoutpage.class);
	driver.close();
}
}
