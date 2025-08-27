package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{

	
	@Test(description="verify the user is able to click manage news")
	
	public void verifyUserisAbleToClickManageNews() throws IOException
	{
     
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1,1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		
		String textmsg=ExcelUtility.getStringData(3, 0, "ManageNewsPage");
		
		ManageNewsPage mnp= new ManageNewsPage(driver);
		mnp.moreInfo();
		mnp.newButtonClick();
		mnp.newsTextBox(textmsg);
		mnp.saveButton();
		
		boolean alerts=mnp.alertmsg();
		Assert.assertTrue(alerts);
		
	}

	
	
}
