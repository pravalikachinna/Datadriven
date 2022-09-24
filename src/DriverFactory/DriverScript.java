package DriverFactory;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonFunctions.FunctionLibrary;
import Config.AppUtil;
import Utilities.ExcelFileUtil;

public class DriverScript extends AppUtil
{
	String inputpath = "C:\\Users\\Newpcworld\\eclipse-workspace\\DDT_Framework\\TestInput\\TestData.xlsx";
	String outputpath = "C:\\Users\\Newpcworld\\eclipse-workspace\\DDT_Framework\\TestOutput\\TestResults.xlsx";
	@Test
	public void startTest()throws Throwable
	{
		//access excel methods
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no.of rows
		int rc=xl.rowcount("pra");
		int cc=xl.cellcount("pra");
		Reporter.log("no.of rows:::"+rc+" "+"no.of cells:::"+cc,true);
		for(int i=1;i<=rc;i++)
		{
			String user = xl.getcellData("pra", i, 0);
			String pass =xl.getcellData("pra",i, 1);
			//call login method from function library class
			boolean res = FunctionLibrary.verifyLogin(user, pass);
			if(res)
			{
				//if it is true write into results and status cell
				xl.setcelldata("pra", i, 2, "loginpass",outputpath);
				xl.setcelldata("pra", i, 3, "pass",outputpath);
			}
			else
			{
			java.io.File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen,new File("./screens/iteration/"+i+" "+"loginpage.png"));
				xl.setcelldata("pra", i, 2, "loginfail",outputpath);
				xl.setcelldata("pra", i, 3, "fail",outputpath);	
	
				
			}
		}
	}

}
