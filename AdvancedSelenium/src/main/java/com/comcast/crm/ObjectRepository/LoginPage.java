package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ccomcast.generic.Webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;

   @FindAll({@FindBy(name="user_name"),@FindBy(xpath="//input[@name='user_name']")})
   private WebElement  userTf;
	
	@FindBy(name="user_password")
	private WebElement passwordTf;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	 public void loginToapp(String url,String username,String password )
	 {
		 
		 waitforPageload(driver);
		 driver.get(url);
		 userTf.sendKeys(username);
		 passwordTf.sendKeys(password);
		 loginBtn.click();
		 
	 }
	

}
