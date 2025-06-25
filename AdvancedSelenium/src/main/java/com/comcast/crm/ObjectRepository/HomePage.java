package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	
  @FindBy(linkText="Organizations")
  private WebElement orgLink;
  
  @FindBy(linkText="Contacts")
  private WebElement contLink;
  
  @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
  private WebElement signImg;
  
  @FindBy(xpath="(//td[@valign='bottom'])[2]")
  private WebElement logImg;
  
  @FindBy(linkText="Sign Out")
  private WebElement signOut;
 
  public HomePage(WebDriver driver)
  {
	 
	  PageFactory.initElements(driver,this );
  }
   
  
  public void getSignOut(WebDriver driver) {
	  Actions ac=new Actions(driver);
	  ac.moveToElement(logImg).perform();
	  signOut.click();
	
}



public WebElement getSignImg() {
	return signImg;
}



public WebElement getOrgLink() {
	return orgLink;
}



public WebElement getContLink() {
	return contLink;
}
  	

}
