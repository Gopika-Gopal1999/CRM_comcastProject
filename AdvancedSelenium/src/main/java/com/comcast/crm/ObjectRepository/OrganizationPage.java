package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy (xpath="//img[@title='Create Organization...']")
	private WebElement orgBtn;
	 WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}
	
	
	

}
