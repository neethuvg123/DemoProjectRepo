package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {

	
	
	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver)
	{
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement moreinfo;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add' and @onclick='click_button(1)']") WebElement newbutton;
	
	@FindBy (xpath="//input[@id='category']") WebElement category;
	
	
	@FindBy (xpath="//div[@class='ms-selectable']//child::ul") WebElement selectgroup;
	
	@FindBy (xpath="//input[@id='main_img']") WebElement choosefile;
	
	@FindBy(xpath="//button[text()='Save']") WebElement save;
	
	
	public void moreinfo()
	{
		moreinfo.click();
	}
	
	public void newbutton()
	{
		newbutton.click();
	}
	
	public void category(String value)
	{
		category.sendKeys(value);
	}
	
	public void groupselect()
	{
		selectgroup.click();
	}
	public void choosefile()
	{
		choosefile.sendKeys("C:\\Users\\user\\Pictures\\Screenshots\\Screenshot (8).png");
	}
	
	public void saveButton()
	{
		save.click();
	}
}
