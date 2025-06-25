package com.sel.generic;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgCmd {
	@Test
	public void createOrg(XmlTest test)
	{
		String Browser=test.getParameter("Browser");
		String url=test.getParameter("Url");
		String username=test.getParameter("Username");
		String password=test.getParameter("Password");
		//String url=System.getProperty("url");
		 //String Browser=System.getProperty("browser");
		 //String username=System.getProperty("username");
		 //String password=System.getProperty("password");
		WebDriver driver= null;
		if(Browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		 driver.get( url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.quit();
	}

}
