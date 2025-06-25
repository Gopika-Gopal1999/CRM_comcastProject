package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfopage {
 @FindBy(xpath="//span[@class='dvHeaderText']")
 private WebElement headerText;
 
 
 public OrganizationInfopage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }




public WebElement getHeaderText() {
	return headerText;
}
 
}
