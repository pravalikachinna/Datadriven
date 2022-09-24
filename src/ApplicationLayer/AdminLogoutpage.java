package ApplicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutpage
{
	@FindBy(linkText="Welcome shweta")
	WebElement clickWelcome;
	@FindBy(linkText="Logout")
	WebElement clicklogout;
	public void verifyLogout()
	{
		clickWelcome.click();
		clicklogout.click();
	}

}
