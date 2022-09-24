
package Config;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil
{
public static WebDriver driver;
public static Properties config;
@BeforeTest
public static void setup() throws Throwable
{
	config = new Properties();
	config.load(new FileInputStream("C:\\Users\\Newpcworld\\eclipse-workspace\\DDT_Framework\\PropertyFiles\\Environment.Properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("Browser value not matching:::");
	}
}
@AfterTest
public static void teardown()
{
	driver.close();
}
}



	
