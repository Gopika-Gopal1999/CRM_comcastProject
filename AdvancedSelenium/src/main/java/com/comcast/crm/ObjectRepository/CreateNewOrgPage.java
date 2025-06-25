package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrgPage {

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameTf;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDp;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typeDp;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	
	public CreateNewOrgPage(WebDriver driver)
	{

		PageFactory.initElements(driver, this);
	}
	

	public void setOrgName(String orgName)
	{
		orgNameTf.sendKeys(orgName);
		saveBtn.click();
	
	}
	public void setOrgName(String orgName,String industry,String type )
	{
		orgNameTf.sendKeys(orgName);
		Select sel=new Select(industryDp);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(typeDp);
		sel1.selectByVisibleText(type);
		saveBtn.click();
		
		
	}
	 
}