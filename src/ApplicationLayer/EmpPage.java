package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class EmpPage
{
	WebDriver driver;
	//constructor to override webdriver methods
	public EmpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//define repository
	@FindBy(xpath="//b[normalize-space()='PIM']")
	WebElement clickPim;
	@FindBy(id="btnAdd")
	WebElement clickAddbtn;
	@FindBy(name="firstName")
	WebElement EnterFname;
	@FindBy(name="middleName")
	WebElement EnterMname;
	@FindBy(name="lastName")
	WebElement EnterLname;
	@FindBy(name="employeeId")
	WebElement BeforeId;
	@FindBy(xpath = "//input[@value='Save']")
	WebElement ClickSavebtn;
	@FindBy(name="personal[txtEmployeeId]")
    WebElement AfterEid;
	public boolean verifyAddEmp(String EnterFname,String EnterMname,String EnterLname)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(this.clickPim).click().perform();
		ac.moveToElement(this.clickAddbtn).click().perform();
		this.EnterFname.sendKeys(EnterFname);
		this.EnterMname.sendKeys(EnterMname);
		this.EnterLname.sendKeys(EnterLname);
		String expectedEid=this.BeforeId.getAttribute("value");
		ac.moveToElement(this.ClickSavebtn).click().perform();
		String ActualEid=this.AfterEid.getAttribute("value");
		if(expectedEid.equalsIgnoreCase(ActualEid))
		{
			                                               
		Reporter.log("Emp creation success:::"+expectedEid+" "+ActualEid,true);	
		return true;
		}
		else
		{
			Reporter.log("Emp creation fail:::"+expectedEid+" "+ActualEid,true);	
			return false;	
		}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}


