package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test
	
	
	public void verifyuserIsAbleToclickManageCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1,1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		
		String lists=ExcelUtility.getStringData(3, 0, "ManageCategoryPage");
		
		ManageCategoryPage mcp=new ManageCategoryPage(driver);
		mcp.moreinfo();
		mcp.newbutton();
		mcp.category(lists);
		mcp.groupselect();
		mcp.choosefile();
		mcp.saveButton();
		
	}

}
