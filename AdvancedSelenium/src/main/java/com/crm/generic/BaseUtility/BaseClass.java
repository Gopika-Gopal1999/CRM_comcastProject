package com.crm.generic.BaseUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.helpers.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ccomcast.generic.Webdriverutility.JavaUtility;
import com.ccomcast.generic.Webdriverutility.UtilityClassObject;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;

public class BaseClass {
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public ExcelUtility excel=new ExcelUtility();
	public static WebDriver sDriver=null;
	
	public WebDriver driver=null;
	
	//@BeforeSuite
	public void configBs() throws SQLException
	{
		//System.out.println("====Exectued Db connection==== ");
		dLib.getDBconnecction();
		}
	@org.testng.annotations.BeforeClass(groups="Smoke")
	public void configBc() throws IOException
	{
		String Browser = fLib.getDataFromPropertiesFile("browser");
		
		System.out.println(Browser);
		if(Browser.contains("Chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(Browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}	
		sDriver=driver;
		UtilityClassObject.setdriver(driver);
	}
	
	@BeforeMethod(groups="Smoke")
	public void configBm() throws IOException
	{
	
		System.out.println("===Login==");
		String Url = fLib.getDataFromPropertiesFile("url");
		String Username = fLib.getDataFromPropertiesFile("username");
		String Password = fLib.getDataFromPropertiesFile("password");
		
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(Url, Username, Password);
		
	}
	@AfterMethod
	public void configAm()
	{
		System.out.println("====Logout===");
		HomePage ho=new HomePage(driver);
		ho.getSignOut(driver);
	}
	
	@AfterClass
	public void configAc()
	{
		System.out.println("===Close the Browser====");
		driver.quit();
	}
	
	//@AfterSuite
	public void configAs()
	{
		System.out.println("===Db connection close===");
		dLib.closeDbconnectio();
	}
	
	}