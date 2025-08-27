package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;
import utilities.WaitUtility;



public class Base {

	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserIntialization(String browser) throws Exception
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else
		{
			throw new Exception("invalid browser name");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod(alwaysRun=true)
	
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility  scrShot = new ScreenshotUtility (); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
driver.quit();
	}
}
